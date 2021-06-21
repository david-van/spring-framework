最开始的5个类
0 = "org.springframework.context.annotation.internalConfigurationAnnotationProcessor"
1 = "org.springframework.context.annotation.internalAutowiredAnnotationProcessor"
2 = "org.springframework.context.annotation.internalCommonAnnotationProcessor"
3 = "org.springframework.context.event.internalEventListenerProcessor"
4 = "org.springframework.context.event.internalEventListenerFactory"


执行初始化bean的生命周期的spring中内置的类
org.springframework.context.annotation.internalConfigurationAnnotationProcessor
org.springframework.context.event.internalEventListenerProcessor
org.springframework.context.event.internalEventListenerFactory
org.springframework.context.annotation.internalAutowiredAnnotationProcessor
org.springframework.context.annotation.internalCommonAnnotationProcessor



org.springframework.context.annotation.ConfigurationClassPostProcessor.configurationClass


registerBeanDefinitions:45, AspectJAutoProxyRegistrar (org.springframework.context.annotation)
registerBeanDefinitions:86, ImportBeanDefinitionRegistrar (org.springframework.context.annotation)
lambda$loadBeanDefinitionsFromRegistrars$1:387, ConfigurationClassBeanDefinitionReader (org.springframework.context.annotation)
accept:-1, 659590237 (org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader$$Lambda$58)
forEach:684, LinkedHashMap (java.util)
loadBeanDefinitionsFromRegistrars:386, ConfigurationClassBeanDefinitionReader (org.springframework.context.annotation)
loadBeanDefinitionsForConfigurationClass:151, ConfigurationClassBeanDefinitionReader (org.springframework.context.annotation)
loadBeanDefinitions:120, ConfigurationClassBeanDefinitionReader (org.springframework.context.annotation)
processConfigBeanDefinitions:358, ConfigurationClassPostProcessor (org.springframework.context.annotation)
postProcessBeanDefinitionRegistry:240, ConfigurationClassPostProcessor (org.springframework.context.annotation)
invokeBeanDefinitionRegistryPostProcessors:303, PostProcessorRegistrationDelegate (org.springframework.context.support)
invokeBeanFactoryPostProcessors:101, PostProcessorRegistrationDelegate (org.springframework.context.support)
invokeBeanFactoryPostProcessors:789, AbstractApplicationContext (org.springframework.context.support)
refresh:583, AbstractApplicationContext (org.springframework.context.support)
main:18, DemoAop (com.david.demo.source.reader.aop)

