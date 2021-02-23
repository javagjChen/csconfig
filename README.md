# CustomizeSpringConfig 自定义配置
## 背景：
  多开发人员共同开发一个项目时，如果使用到配置中心（如目前主流的Apollo，Nacos，spring cloud Config等），一般都是一个环境一个配置中心。调试时难免会需要修改一些配置，这样势必影响到其他开发人员。通常遇到这种情况一般是在自己的本地再起一个配置中心或者基于spring的特性使用命令行进行修改配置（因为命令行的配置优先级最高）。
## 需要：
  那么有没有办法不需要再起一个配置中心，也不需要使用命令行指定配置呢？
## 意义：
  答案是有的，利用spring的spi和环境配置顺序可以自定义自己专属的配置！
