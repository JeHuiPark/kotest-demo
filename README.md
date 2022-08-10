# Spring, Kotest gist 

- [Kotest Official](https://kotest.io/)
- [Install intelliJ plugin](https://kotest.io/docs/intellij/intellij-plugin.html)
- [Kotest github](https://github.com/kotest/kotest)
- [Kotest Maven](https://mvnrepository.com/artifact/io.kotest)
- [Mockk Spring Integration](https://github.com/Ninja-Squad/springmockk)

## Mockk Glossary

| word         | description                                                                                                                                                                                                                                                                                            |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| relaxed mock | mockk의 모의 객체는 기본 설정이 엄격하게 동작하도록 되어있다 (not relaxed)<br/>객체의 행동을 반드시 지정해주어야 한다는 의미이며, 지정되지 않은 행동을 수행하면 mockk는 이것을 테스트 실패로 처리한다 <br/>다만, relaxed 옵션을 이용하여 이러한 기본 정책을 완화시킬 수 있으며 이것을 relaxed mock이라고 한다 (완화된 모의객체)<br/> 이 설정은 [mockk setting properties](https://mockk.io/#settings-file) 로 기본설정을 변경할 수 있다 |
