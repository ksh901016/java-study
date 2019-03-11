### InputStream, OutputStream (파일입출력_1)

스트림(Stream)은 단일 방향으로 연속적으로 흘러가는 것을 말함

자바에서는 프로그램이 데이터를 입력받을 때에는 입력 스트림(InputStream), 데이터를 보낼 때에는 출력 스트림(OutputStream)이라고 부른다.

(예) 입력스트림 : 파일, 키보드, 프로그램 // 출력스트림 : 파일, 모니터, 프로그램



**스트림 클래스 종류**

1. 바이트(byte)기반 스트림 (그림, 멀티미디어, 문자 등) 
   * InputStream
   * OutputStream
2. 문자(character)기반 스트림 (문자)
   * Reader
   * Writer

InputStream, OutputStream, Reader, Writer는 모두 최상위 클래스로 추상클래스에 해당한다. 따라서 우리가 직접 사용할 클래스들은 이 네 클래스들의 하위 클래스이다.



**InputStream 주요 메소드**

| 리턴타입 | 메소드                           | 설명                                                         |
| -------- | -------------------------------- | ------------------------------------------------------------ |
| int      | read()                           | 입력 스트림으로부터 1바이트를 읽고 바이트를 리턴             |
| int      | read(byte[] b)                   | 입력 스트림으로부터 읽은 바이트들을 매개값으로 주어진 바이트 배열b에 저장하고 실제로 읽은 바이트 수를 리턴 |
| int      | read(byte[] b, int off, int len) | 입력 스트림으로부터 len개의 바이트만큼 읽고 매개값으로 주어진 바이트 배열 b[off]부터 len개까지 저장한다. 실제로 읽은 바이트 수인 len을 리턴한다. |
| void     | close()                          | 자원을 반납하고 입력 스트림을 닫는다.                        |

```java
// read()
InputStream is = new FileInputStream("C://test.jpg");
int readBytes;
while((readBytes = is.read()) != -1){ .. }

// read(byte[])
InputStream is = new FileInputStream("C://test.jpg");
int readBytesCount;
byte[] readBytes = new byte[100];
while((readBytesCount = is.read(readBytes)) != -1){ .. }
// 많은 양의 바이트를 읽을 때는 read() 보다 read(byte[])를 사용해야 루핑 횟수를 현저히 줄일 수 있다.
```



**OutputStream 주요메소드**

| 리턴 타입 | 메소드                            | 설명                                                         |
| --------- | --------------------------------- | ------------------------------------------------------------ |
| void      | write(int b)                      | 출력 스트림으로 1바이트를 보낸다.(b의 끝 1바이트)            |
| void      | write(byte[] b)                   | 출력 스트림으로 바이트 배열 b의 모든 바이트를 보낸다.        |
| void      | write(byte[] b, int off, int len) | 출력 스트림으로 주어진 바이트 배열 b[off] 부터 len개까지의 바이트를 보낸다. |
| void      | flush()                           | 버퍼에 잔류하는 모든 바이트를 출력한다.                      |
| void      | close()                           | 자원을 반납하고 스트림을 닫는다.                             |

```java
// write(int b)
OutputStream os = new FileOutputStream("c://test.txt");
byte[] data "ABC".getBytes();
for(int i=0; i<data.length; i++){
    os.write(data[i]);
}

// write(byte[] b)
OutputStream os = new FileOutputStream("c://test.txt");
byte[] data "ABC".getBytes();
os.write(data);
```



