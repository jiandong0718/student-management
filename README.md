# 🎓 Student Management System | 学生管理系统

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2022.x-green.svg)](https://spring.io/projects/spring-cloud)
[![MyBatis Plus](https://img.shields.io/badge/MyBatis%20Plus-3.x-red.svg)](https://baomidou.com/)
[![Nacos](https://img.shields.io/badge/Nacos-2.x-blue.svg)](https://nacos.io/)
[![Kafka](https://img.shields.io/badge/Kafka-3.x-yellow.svg)](https://kafka.apache.org/)
[![XXL-Job](https://img.shields.io/badge/XXL--Job-2.x-purple.svg)](https://github.com/xuxueli/xxl-job)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> 🚀 基于Java+Spring Boot+Spring Cloud+MyBatis构建的教育机构B端管理后台系统，集成Nacos、Kafka、XXL-Job等主流中间件，专为中小型教育机构设计，提供完整的学生管理、教学管理、财务管理等功能。

## 📋 项目简介

本项目是一个全面的教育机构管理后台系统，采用Spring Cloud微服务架构和现代化的技术栈，集成Nacos、Kafka、XXL-Job等主流中间件，旨在帮助教育机构提升管理效率、优化教学质量并提供数据支持决策。

### 🎯 核心特性

- **🔐 权限管理**：细粒度的角色权限控制，多层级管理架构
- **👨‍🎓 学生管理**：完整的学生档案管理，从招生到毕业全流程跟踪
- **👨‍🏫 教师管理**：教师档案、绩效评估、薪资管理一体化
- **📚 课程管理**：课程库管理、教学资源整合、课程评价体系
- **🏫 班级管理**：智能分班、班级动态监控、学习氛围分析
- **📅 排课系统**：可视化排课、冲突检测、资源优化分配
- **📊 数据分析**：多维度运营数据分析，智能决策支持
- **💰 财务管理**：收费管理、退费处理、财务报表自动化
- **📱 移动端**：响应式设计，支持移动办公
- **🌐 微服务架构**：Spring Cloud生态，服务治理完善
- **⚡ 高性能缓存**：Redis+Caffeine双级缓存，响应速度快
- **🔄 异步处理**：Kafka消息队列，系统解耦高效
- **⏰ 任务调度**：XXL-Job分布式任务调度，定时任务可视化管理

## 🏗️ 技术架构

### 技术栈

| 层次 | 技术 | 版本 | 说明 |
|------|------|------|------|
| **后端框架** | Spring Boot | 3.x | 核心框架 |
| **微服务框架** | Spring Cloud | 2022.x | 微服务生态 |
| **服务调用** | OpenFeign | 4.x | 服务间通信 |
| **数据访问** | MyBatis Plus | 3.x | ORM框架 |
| **关系型数据库** | MySQL | 8.0+ | 主数据库 |
| **文档数据库** | MongoDB | 6.0+ | 非关系型数据库 |
| **分布式缓存** | Redis | 7.0+ | 分布式缓存 |
| **本地缓存** | Caffeine | 3.x | 高性能本地缓存 |
| **注册中心** | Nacos | 2.x | 服务注册与发现 |
| **配置中心** | Nacos | 2.x | 分布式配置管理 |
| **任务调度** | XXL-Job | 2.x | 分布式任务调度 |
| **消息队列** | Kafka | 3.x | 消息分发与异步解耦 |
| **安全框架** | Spring Security | 6.x | 认证授权 |
| **文档工具** | Springdoc OpenAPI | 2.x | API文档 |
| **构建工具** | Maven | 3.8+ | 项目构建 |
| **Java版本** | JDK | 17+ | 运行环境 |

### 架构设计

采用"**核心单体+周边微服务**"的混合架构模式，集成Spring Cloud生态：

```
┌─────────────────────────────────────────────────────────────┐
│                     API Gateway                            │
├─────────────────────────────────────────────────────────────┤
│  Core Service (核心单体应用)                                │
│  ├─ User & Auth Module      ├─ Teaching Module             │
│  ├─ Operation Module        ├─ Finance Module              │
├─────────────────────────────────────────────────────────────┤
│  Microservices (独立微服务)                                 │
│  ├─ Analytics Service       ├─ Notification Service        │
│  ├─ Marketing Service       ├─ File Storage Service        │
├─────────────────────────────────────────────────────────────┤
│  Middle-ware (中间件层)                                     │
│  ├─ Nacos (注册中心)        ├─ Nacos (配置中心)             │
│  ├─ Kafka (消息队列)        ├─ XXL-Job (任务调度)           │
│  ├─ OpenFeign (服务调用)    ├─ Caffeine (本地缓存)         │
├─────────────────────────────────────────────────────────────┤
│  Data Layer (数据层)                                        │
│  ├─ MySQL (关系型数据库)    ├─ MongoDB (文档数据库)         │
│  ├─ Redis (分布式缓存)      ├─ 数据持久化                  │
├─────────────────────────────────────────────────────────────┤
│  Infrastructure (基础设施)                                  │
│  ├─ Monitoring Service      ├─ Log Service                 │
│  ├─ Health Check           ├─ Security Service            │
└─────────────────────────────────────────────────────────────┘
```

## 🚀 快速开始

### 环境要求

- **JDK 17+**
- **Maven 3.8+** 
- **MySQL 8.0+**
- **MongoDB 6.0+**
- **Redis 7.0+**
- **Nacos 2.x**
- **Kafka 3.x**
- **XXL-Job 2.x**

### 安装与运行

1. **克隆项目**
   ```bash
   git clone https://github.com/your-username/student-management.git
   cd student-management
   ```

2. **数据库配置**
   ```bash
   # 创建数据库
   mysql -u root -p
   CREATE DATABASE student_management CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

3. **中间件环境准备**
   ```bash
   # 启动Nacos (注册中心 + 配置中心)
   sh startup.sh -m standalone
   
   # 启动Kafka
   bin/kafka-server-start.sh config/server.properties
   
   # 启动XXL-Job调度中心
   # 参考XXL-Job官方文档部署调度中心
   ```

4. **修改配置**
   ```yaml
   # src/main/resources/application-dev.yml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/student_management
       username: your_username
       password: your_password
     data:
       mongodb:
         uri: mongodb://localhost:27017/student_management
     cloud:
       nacos:
         discovery:
           server-addr: localhost:8848
         config:
           server-addr: localhost:8848
     kafka:
       bootstrap-servers: localhost:9092
       consumer:
         group-id: student-management-group
   
   # XXL-Job配置
   xxl:
     job:
       admin:
         addresses: http://localhost:8080/xxl-job-admin
       executor:
         appname: student-management-executor
         address: 
         ip: 
         port: 9999
   ```

5. **运行应用**
   ```bash
   # 开发环境
   mvn spring-boot:run -Dspring-boot.run.profiles=dev
   
   # 或使用Maven Wrapper
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
   ```

6. **访问应用**
   - 应用地址：http://localhost:8080
   - API文档：http://localhost:8080/swagger-ui.html
   - Nacos控制台：http://localhost:8848/nacos
   - XXL-Job控制台：http://localhost:8080/xxl-job-admin
   - 默认管理员：admin/admin123

## 📦 项目结构

```
student-management/
├── common-lib/                 # 公共库
│   ├── config/                # 配置类
│   ├── controller/            # 基础控制器
│   ├── exception/             # 异常处理
│   ├── model/                 # 基础模型
│   ├── response/              # 响应封装
│   └── util/                  # 工具类
├── src/main/java/com/example/studentManagement/
│   ├── config/                # 配置类
│   │   ├── NacosConfig.java   # Nacos配置
│   │   ├── KafkaConfig.java   # Kafka配置
│   │   ├── CacheConfig.java   # 缓存配置
│   │   └── XxlJobConfig.java  # XXL-Job配置
│   ├── controller/            # 控制器层
│   ├── dto/                   # 数据传输对象
│   ├── entity/                # 实体类
│   ├── mapper/                # 数据访问层
│   ├── service/               # 业务逻辑层
│   ├── security/              # 安全配置
│   ├── task/                  # 定时任务
│   ├── message/               # 消息处理
│   └── feign/                 # 服务调用接口
├── src/main/resources/
│   ├── application*.yml       # 配置文件
│   ├── bootstrap.yml          # Nacos启动配置
│   ├── kafka/                 # Kafka配置
│   └── static/                # 静态资源
└── src/test/                  # 测试代码
```

## 🔧 功能模块

### 核心功能

| 模块 | 功能描述 | 状态 |
|------|----------|------|
| **用户权限管理** | 多角色权限控制、登录安全 | ✅ |
| **学生管理** | 学生档案、招生管理、学习跟踪 | ✅ |
| **教师管理** | 教师档案、绩效评估、薪资管理 | ✅ |
| **课程管理** | 课程库、定价策略、教学资源 | ✅ |
| **班级管理** | 智能分班、班级动态监控 | ✅ |
| **排课系统** | 可视化排课、冲突检测 | 🚧 |
| **考勤管理** | 考勤统计、异常提醒 | 🚧 |
| **成绩管理** | 成绩录入、分析报表 | 🚧 |
| **财务管理** | 收费管理、财务报表 | 🚧 |
| **数据分析** | 运营看板、多维度分析 | 📋 |

> 状态说明：✅ 已完成 | 🚧 开发中 | 📋 计划中

### 高级功能

- **📊 数据分析**：运营数据看板、学生分析、教学质量评估
- **📱 消息通知**：站内消息、短信、邮件、家校沟通
- **🎯 营销工具**：活动管理、优惠券、推荐奖励
- **🏢 多校区支持**：资源共享、数据汇总、对比分析
- **📱 移动端**：响应式设计、移动办公支持
- **🔧 服务治理**：Nacos服务注册发现、配置中心统一管理
- **⚡ 性能优化**：多级缓存策略、异步消息处理、任务调度优化
- **📈 可扩展性**：微服务架构、水平扩展、弹性伸缩
- **🛡️ 高可用性**：服务熔断、降级、限流、监控告警

## 🛠️ 开发指南

### 代码规范

- **命名约定**：遵循Java驼峰命名规范
- **代码风格**：基于Google Java Style Guide
- **注释规范**：使用JavaDoc标准
- **Git提交**：采用Conventional Commits规范

### 开发环境配置

```bash
# 安装依赖
mvn clean install

# 运行测试
mvn test

# 代码格式化
mvn spring-javaformat:apply

# 生成API文档
mvn springdoc-openapi:generate

# 本地开发环境启动中间件 (Docker Compose)
docker-compose up -d nacos mysql redis mongodb kafka xxljob

# 检查服务状态
docker-compose ps

# 停止服务
docker-compose down
```

## 📊 API文档

项目集成了Springdoc OpenAPI，提供完整的API文档：

- **Swagger UI**：http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**：http://localhost:8080/v3/api-docs

## 🧪 测试

```bash
# 运行所有测试
mvn test

# 运行集成测试
mvn test -Dtest=**/*IntegrationTest

# 生成测试报告
mvn jacoco:report
```

## 🚀 部署

### Docker部署

```bash
# 使用Docker Compose一键部署
docker-compose -f docker-compose.prod.yml up -d

# 或分步部署
# 1. 构建应用镜像
docker build -t student-management .

# 2. 启动基础中间件
docker-compose up -d nacos mysql redis mongodb kafka xxljob

# 3. 运行应用容器
docker run -p 8080:8080 \
  --link nacos:nacos \
  --link mysql:mysql \
  --link redis:redis \
  --link mongodb:mongodb \
  --link kafka:kafka \
  student-management
```

### 传统部署

```bash
# 打包
mvn clean package -Pproduction

# 运行
java -jar target/student-management-*.jar --spring.profiles.active=prod
```

## 🤝 贡献指南

我们欢迎所有形式的贡献，包括但不限于：

1. **🐛 Bug报告**：发现问题请提交Issue
2. **✨ 功能建议**：欢迎提出新功能想法
3. **📝 文档改进**：帮助改进项目文档
4. **💻 代码贡献**：提交Pull Request

### 贡献流程

1. Fork项目
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送分支 (`git push origin feature/AmazingFeature`)
5. 创建Pull Request

## 📄 许可证

本项目采用MIT许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。

## 🙏 致谢

感谢所有为本项目做出贡献的开发者！

## 📞 联系我们

- **项目主页**：https://github.com/your-username/student-management
- **问题反馈**：https://github.com/your-username/student-management/issues
- **邮箱**：your-email@example.com

---

⭐ 如果这个项目对您有帮助，请给我们一个Star！ 