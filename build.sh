#!/bin/bash

# 学生管理系统 - 编译脚本
echo "🚀 开始编译学生管理系统..."

# 编译整个项目
echo "📦 编译整个项目..."
./mvnw clean install -DskipTests

if [ $? -eq 0 ]; then
    echo "✅ 编译成功！"
    echo ""
    echo "📂 编译结果："
    echo "   - Common模块: common/target/common-1.0.0.jar"
    echo "   - 学生服务: student-service/target/student-service-1.0.0.jar"
    echo "   - 教师服务: teacher-service/target/teacher-service-1.0.0.jar"
    echo ""
    echo "🏃 启动服务："
    echo "   学生服务: java -jar student-service/target/student-service-1.0.0.jar"
    echo "   教师服务: java -jar teacher-service/target/teacher-service-1.0.0.jar"
    echo ""
    echo "🌐 访问地址："
    echo "   学生服务: http://localhost:8081"
    echo "   教师服务: http://localhost:8082"
    echo "   学生服务API文档: http://localhost:8081/swagger-ui.html"
    echo "   教师服务API文档: http://localhost:8082/swagger-ui.html"
else
    echo "❌ 编译失败，请检查错误信息"
    exit 1
fi 