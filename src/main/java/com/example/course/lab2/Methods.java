package com.example.course.lab2;

public class Methods {
    @MethodAnnotation(count = 2)
    public String printPublicMethodInfo() {
        return "Everyone can easily call me. Also I haven't got any parameter\n";
    }

    @MethodAnnotation(count = 2)
    public String printPublicMethodWithParameterInfo(String name, int age) {
        return "Everyone can easily call me. Also I have some parameters. For example: Name = " + name + " and may be his age = " + age + "\n";
    }

    @MethodAnnotation(count = 3)
    private String printPrivateMethodInfo() {
        return "Only my developer should know about me, because i am his secret. But if you call me, you know that I haven't got any parameter\n";
    }

    @MethodAnnotation(count = 3)
    private String printPrivateMethodWithParameterInfo(String name, int age) {
        return "Only my developer should know about me, because i am his secret. But if you call me, you know that I have some parameters. I shouldn't share it with you, but it is name = " + name + " age = " + age + "\n";
    }

    @MethodAnnotation(count = 4)
    protected String printProtectedMethodInfo() {
        return "Only my children and developer should know about me, because i am his secret. But if you call me, you know that I haven't got any parameter\n";
    }

    @MethodAnnotation(count = 4)
    protected String printProtectedMethodWithParameterInfo(String name, int age) {
        return "Only my children and developer should know about me, because i am our secret. But if you call me, you know that I have some parameters. it is name = " + name + " age = " + age + "\n";
    }
}
