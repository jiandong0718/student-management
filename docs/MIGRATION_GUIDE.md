# 🚀 快速迁移指南

## 📋 迁移概述

本指南帮助您从现有代码结构迁移到新的DDD架构，确保平滑过渡和向后兼容性。

## 🔄 核心变更

### 1. 包结构变更

**旧结构 → 新结构**

```
旧: com.example.studentManagement.entity.Student
新: com.example.studentManagement.domain.teaching.entity.Student

旧: com.example.studentManagement.service.StudentService
新: com.example.studentManagement.domain.teaching.service.StudentDomainService
    com.example.studentManagement.application.service.StudentApplicationService
```

### 2. 实体类变更

**旧代码**
```java
@Entity
@TableName("students")
public class Student {
    @TableId
    private Long id;
    private String studentId;
    // ... 其他字段
}
```

**新代码**
```java
@Entity
@TableName("students")
public class Student extends AggregateRoot {
    @TableId
    private Long id;
    private String studentId;
    
    // 工厂方法
    public static Student create(String studentId, String firstName, String lastName, String email) {
        Student student = Student.builder()
                .studentId(studentId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
        
        // 发布领域事件
        student.addDomainEvent(new StudentEnrolledEvent(student.getAggregateId(), student));
        return student;
    }
    
    // 业务方法
    public void updateInfo(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        
        // 发布领域事件
        this.addDomainEvent(new StudentUpdatedEvent(this.getAggregateId(), this));
    }
}
```

### 3. 服务层变更

**旧代码**
```java
@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Override
    public Student addStudent(Student student) {
        studentMapper.insert(student);
        return student;
    }
}
```

**新代码**
```java
// 领域服务
@Service
public class StudentDomainService {
    
    public boolean canEnrollCourse(Student student, Course course) {
        return student.isActive() && course.canEnroll();
    }
}

// 应用服务
@Service
@Transactional
public class StudentApplicationService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private DomainEventPublisher eventPublisher;
    
    public Student createStudent(CreateStudentCommand command) {
        Student student = Student.create(
            command.getStudentId(),
            command.getFirstName(),
            command.getLastName(),
            command.getEmail()
        );
        
        Student savedStudent = studentRepository.save(student);
        
        // 发布事件
        savedStudent.getUncommittedEvents().forEach(event -> {
            eventPublisher.publishAll(event);
        });
        savedStudent.clearDomainEvents();
        
        return savedStudent;
    }
}
```

## 🔧 逐步迁移步骤

### 步骤1：更新依赖和配置

1. **更新pom.xml**（已完成）
2. **更新application.yml**（已完成）
3. **更新启动类扫描包**（已完成）

### 步骤2：创建新的基础设施

1. **创建通用响应类**
```java
// 将现有的ApiResponse替换为新的统一响应
// 位置：src/main/java/com/example/studentManagement/common/response/ApiResponse.java
```

2. **创建事件发布器**
```java
// 新增事件发布功能
// 位置：src/main/java/com/example/studentManagement/common/event/DomainEventPublisher.java
```

### 步骤3：迁移实体类

1. **备份原有实体**
```bash
cp -r src/main/java/com/example/studentManagement/entity backup/
```

2. **创建新的领域实体**
```java
// 新位置：src/main/java/com/example/studentManagement/domain/teaching/entity/
// 继承AggregateRoot
// 添加工厂方法
// 添加业务方法
```

3. **更新Mapper扫描**
```java
@MapperScan(basePackages = {
    "com.example.studentManagement.mapper",
    "com.example.studentManagement.domain.*.repository"
})
```

### 步骤4：迁移服务层

1. **保持原有Service接口**（向后兼容）
```java
// 保持原有的StudentService接口不变
public interface StudentService {
    Student getStudentById(Long id);
    // ... 其他方法
}
```

2. **创建适配器实现**
```java
@Service
public class StudentServiceAdapter implements StudentService {
    
    @Autowired
    private StudentApplicationService studentApplicationService;
    
    @Override
    public Student getStudentById(Long id) {
        return studentApplicationService.getStudentById(id);
    }
}
```

### 步骤5：迁移Controller层

1. **保持原有API不变**
```java
@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService; // 注入适配器
    
    @PostMapping
    public ApiResponse<Student> createStudent(@RequestBody Student student) {
        Student created = studentService.addStudent(student);
        return ApiResponse.success(created);
    }
}
```

## 🏃‍♂️ 快速启动

### 1. 编译和运行

```bash
# 清理并编译
mvn clean compile

# 运行应用
mvn spring-boot:run

# 或者使用IDE运行
# 主类：com.example.studentManagement.StudentManagementApplication
```

### 2. 测试新功能

```bash
# 创建学生
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "studentId": "S001",
    "firstName": "张",
    "lastName": "三",
    "email": "zhangsan@example.com"
  }'

# 查询学生
curl http://localhost:8080/api/students/1
```

### 3. 查看事件日志

```bash
# 查看应用日志中的事件发布信息
tail -f logs/application.log | grep "Publishing.*event"
```

## 🔍 验证迁移

### 1. 功能验证

- [ ] 学生CRUD操作正常
- [ ] 课程CRUD操作正常
- [ ] 选课功能正常
- [ ] 事件发布正常

### 2. 性能验证

- [ ] 响应时间无明显变化
- [ ] 内存使用正常
- [ ] 数据库连接正常

### 3. 兼容性验证

- [ ] 现有API正常工作
- [ ] 数据库数据完整
- [ ] 前端调用正常

## 🛠️ 常见问题

### Q1: 启动时报找不到Bean错误

**解决方案**：
```java
// 检查@ComponentScan注解是否包含所有必要的包
@ComponentScan(basePackages = {
    "com.example.studentManagement",
    "com.example.common"
})
```

### Q2: 事件发布失败

**解决方案**：
```yaml
# 检查Kafka配置
spring:
  kafka:
    bootstrap-servers: localhost:9092
    consumer:
      group-id: student-management-group
```

### Q3: 数据库连接异常

**解决方案**：
```yaml
# 检查数据库配置
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/student_management
    username: your_username
    password: your_password
```

## 📈 性能优化建议

### 1. 缓存策略

```java
@Service
public class StudentQueryService {
    
    @Cacheable(value = "students", key = "#studentId")
    public Student getByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }
}
```

### 2. 异步事件处理

```java
@EventListener
@Async
public void handleStudentEnrolledEvent(StudentEnrolledEvent event) {
    // 异步处理事件
}
```

### 3. 批量操作

```java
public class StudentApplicationService {
    
    @Transactional
    public void createStudentsBatch(List<CreateStudentCommand> commands) {
        List<Student> students = commands.stream()
            .map(cmd -> Student.create(cmd.getStudentId(), cmd.getFirstName(), cmd.getLastName(), cmd.getEmail()))
            .collect(Collectors.toList());
        
        studentRepository.saveAll(students);
    }
}
```

## 🎯 下一步计划

1. **完善领域模型**：添加更多业务规则和验证
2. **实现CQRS**：分离命令和查询
3. **添加监控**：性能监控和业务监控
4. **准备拆分**：按领域边界准备微服务拆分

---

**📝 说明**：如果在迁移过程中遇到问题，请参考`ARCHITECTURE_REFACTOR_GUIDE.md`中的详细说明。 