package com.kodilla.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class UserAgent {

    public static void premain(String args, Instrumentation instrumentation) {

        AgentBuilder agentBuilder = new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("com.kodilla.bytebuddy.User"))
                .transform(((builder, typeDescription, classLoader, module, protectionDomain)
                        -> builder.visit(Advice.to(MyMethodMonitor.class).on(ElementMatchers.hasMethodName("doSomething")))));

        agentBuilder.installOn(instrumentation);
    }
}