# 스프링 핵심기술 (2편)
<br/>

# Resource 추상화
- java.net.URL을 org.springframework.core.io.Resource로 감싼 것.(추상화 한 것.)
- 스프링 내부에서 많이 사용하는 인터페이스.
- 기존 java.net.URL은 classpath 기준으로 리소스를 가져오는 기능이 없었음.
- org.springframework.core.io.Resource에서는 여러가지 prefix를 지원. (http, ftp, https 등)

### 추상화한 이유
- 클래스패스 기준으로 리소스 읽어오는 기능 부재.
- ServletContext를 기준으로 상대 경로로 읽어오는 기능 부재.
- 새로운 핸들러를 등록하여 특별한 URL 접미사를 만들어 사용할 수는 있지만 구현이 복잡하고 편의성 메소드가 부족하다.

### Resource 인터페이스의 메소드
- getInputStream()
- exist()
- isOpen()
- getDescription(): 전체 경로 포함한 파일 이름 또는 실제 URL.

### Resource 구현체
(1) UrlResource: java.net.URL 참고, 기본으로 지원하는 프로토콜 http, https, ftp, file, jar. <br/>
(2) ClassPathResource: 지원하는 접두어 'classpath:' <br/>
(3) FileSystemResource <br/>
(4) ServletContextResource: 웹 애플리케이션 루트에서 상대 경로로 리소스 찾는다. <br/>
> 주로 WebApplicationContext의 구현체인 GenericWebApplicationContext를 사용하기 때문에<br/>
이에 해당하는 ServletContextResource를 많이 사용하게 된다.<br/>
(Resource의 타입은 ApplicationContext의 타입에 따라 결정된다.)<br/>

### 리소스 읽어오기
Resource의 타입은 location 문자열과 ApplicationContext의 타입에 따라 결정된다.<br/>
<br/>
● ClassPathXmlApplicationContext -> ClassPathResource <br/>
● FileSystemXmlApplication -> FileSystemResource <br/>
● WebApplicationContext -> ServletContextResource <br/>
<br/>
ApplicationContext의 타입에 상관없이 리소스 타입을 강제하려면 <br/>
java.net.URL의 접두어 혹은 'classpath:'를 사용할 수 있다. <br/>
<br/>
● classpath:sombrero/config.xml -> ClassPathResource <br/>
● file:///sombrero/config.xml -> FileSystemResource <br/>
<br/>
<pre>
var ctx = new ClassPathXmlApplicationContext("test.xml");
/**
 * 위의 test.xml는 추상화된 ClassPathResource로 내부적으로 변환이 된다.
 * ClassPathXmlApplicationContext는 클래스패스를 기준으로 리소스를 찾는다.
 * 위의 test.xml는 'classpath:test.xml'과 같다.
 */

var ctx2 = new FileSystemXmlApplicationContext("/src/main/resources/test.xml");
/**
 * 위의 test.xml는 추상화된 FileSystemResource로 내부적으로 변환이 된다.
 * FileSystemXmlApplicationContext는 파일시스템 기준으로 리소스를 찾는다.
 */
</pre>
** 대부분은 어떤 ApplicationContext를 사용하는지 알기 어렵기 때문에 명시적으로 접두어를 쓰는 것을 권장.<br/>
그리고 ServletContextResource는 웹 애플리케이션 루트부터 찾는데<br/>
스프링부트의 내장형 톰캣에는 context path가 지정되어 있지 않다. 따라서 리소스를 찾을 수 없다.<br/>
때문에 이와 관련해서도 역시나 'classpath:'와 같이 접두어를 사용하는 것을 권장한다.<br/>

<br/><br/>

# Validation 추상화

<br/><br/>