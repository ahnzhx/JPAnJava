# board
1. JVM, JRE, JDK
* JVM (Java Virtual Machine) 자바 가상 머신으로 자바 바이트 코드(.class 파일)를 OS에 특화된 코드로 변환(인터프리터와 JIT 컴파일러)하여 실행한다. 바이트코   드를 어떻게 실행할 수 있는지에 대한 스펙이다. 구현체가 다양하고 플랫폼에 종속적이다. Native 코드로 바꿔서 실행해야 하는데 Native 코드라는 게 OS에 맞춰 실행해야   하기 때문이다. JVM은 JVM콜로 실행되지 않는다. 최소한의 배포단위가 JRE이다.
* JRE (Java Runtime Environment) 자바 어플리케이션을 실행할 수 있도록 구성된 배포판. 자바 어플리케이션을 실행하는데 필요한 것만 들어있다. (JVM, java 핵심   라이브러리, property Setting 등등) 자바 개발관련 도구는 제공하지 않는다.
* JDK (Java Development Kit) JRE + 개발에 필요한 툴 (ex. javac) Java11부터 jdk 만 제공한다. 자바 9부터 모듈시스템이 들어왔고, 이를 이용해 나만의     jre비슷하게 만들 수 있다. (jlink를 활용해 module의 sub set을 만들 수 있다.) 소스코드를 작성할 때 사용하는 자바언어는 플랫폼에 독립적이다.
