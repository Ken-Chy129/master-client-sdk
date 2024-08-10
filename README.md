# master

Master，顾名思义掌控者，用于管控运行时的配置信息与内存值。Master是一个轻量级的管理框架，提供统一的方式来修改应用程序运行时变量，快速集成，使用便捷。

## 作用

实现运行时内存变量修改，可以用来进行配置修改，开启或关闭某个功能，控制程序的运行逻辑等。

## 应用场景

1. 管理配置项，如URL，接口名，服务调用超时时间等一系列可能会发生变动的配置项都可以通过Master进行控制
2. 开启或关闭某项功能，保证业务的动态性，如动态开启或关闭缓存的使用、开启或关闭某段代码逻辑的执行
3. 其他变量的实时控制，如黑白名单、应用切流百分比等，以实时控制程序的运行逻辑

## 应用架构
