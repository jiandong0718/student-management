#!/bin/bash

# 学生管理系统 - 服务启动脚本

echo "🚀 启动学生管理系统服务..."

# 检查JAR文件是否存在
if [ ! -f "student-service/target/student-service-1.0.0.jar" ]; then
    echo "❌ 未找到学生服务JAR文件，请先编译项目"
    echo "运行: ./build.sh"
    exit 1
fi

if [ ! -f "teacher-service/target/teacher-service-1.0.0.jar" ]; then
    echo "❌ 未找到教师服务JAR文件，请先编译项目"
    echo "运行: ./build.sh"
    exit 1
fi

# 启动学生服务
echo "🎓 启动学生服务 (端口8081)..."
java -jar student-service/target/student-service-1.0.0.jar &
STUDENT_PID=$!

# 等待2秒
sleep 2

# 启动教师服务
echo "👨‍🏫 启动教师服务 (端口8082)..."
java -jar teacher-service/target/teacher-service-1.0.0.jar &
TEACHER_PID=$!

echo ""
echo "✅ 服务启动完成！"
echo "🌐 访问地址："
echo "   学生服务: http://localhost:8081"
echo "   教师服务: http://localhost:8082"
echo "   学生服务API文档: http://localhost:8081/swagger-ui.html"
echo "   教师服务API文档: http://localhost:8082/swagger-ui.html"
echo ""
echo "📋 进程ID："
echo "   学生服务PID: $STUDENT_PID"
echo "   教师服务PID: $TEACHER_PID"
echo ""
echo "🛑 停止服务："
echo "   kill $STUDENT_PID $TEACHER_PID"
echo "   或者按 Ctrl+C 停止此脚本"

# 等待用户中断
wait 