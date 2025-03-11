## 1. 변수

### 1.1. 일반적인 변수 선언

```java
// [Java]
long num1 = 10L; // (1)
final long num2 = 10L; // (2)

Long num3 = 1_000L; // (3)
Person person = new Person("Jack"); // (4)
```

- Java 에서 long 과 final long 의 차이 : 가변인가 불변인가..

```kotlin
var num1 = 10L // val num1: Long = 10L 가능 
val num2 = 10L
```

- 코틀린에서는 `var`, `val` 을 명시 필요
  - `var` : 변경 가능
  - `val` : 변경 불가능
- 타입을 명시적으로 작성해도되지만 값을보고 추론할 수있음
- 초기화 되지 않은 변수는 사용하지 못함 (컴파일 에러)


### 1.2. null ? 

#### null 이 가능한 변수로 호출!?

```kotlin
var num3: Long? = 10L
var person = Person("Jack")
```

- `null` 이 들어갈 수 있는 변수타입은 타입뒤에 `?` 붙여줘야함

```kotlin
val str: String? = "aaa"
str.length // compile error
str?.length // ok
str!!.length // ok 
```

- null 이 가능한 타입의 변수라면 해당 변수로 호출할 수 있는 메소드는 safe call 로 명시해야함
  - safe call : `인스턴스변수명?.메소드()` 
  - null 일 때는 호출하지 않음 
- 또는 이 변수는 무조건 때려죽여도 null 이 아니야!! 라고 단언(assertion) 호출로 넘어갈수도있음
  - assertion call : `인스턴수변수명!!.메소드()`  
  - null 일 때는 NPE 발생 

#### 엘비스(Elvis) 연산자

```kotlin
val str: String? = "aaa"
val strLen = str?.length ?: 0 // 3이 저장됨. 만약 str 에 null 이 저장될수있는 경우라면 0 저장
```

- `?:` 의 앞의 연산 결과가 null 이면 뒤의 값을 사용 

### 1.3. 타입

#### 타입 형변환

```java
int num1 = 100;
long num2 = num1;

System.out.println(num1 + num2); // 200
```

- Java 에서는 더 큰 타입으로 암시적 형변환 됨

```kotlin
val num1 = 4
val num2: Long = num1 // compile error

val num3: Long = num1.toLong()
```

- 코틀린에서 데이터 타입이 맞지 않게 대입하려고하면  compile error
- `toXXX()` 형태의 메소드를 사용하여 명시적으로 형변환 필요 

```kotlin
fun convert(child: Child) {
    if (child is Parent) {
        val parent = child as Parent // as ~ 는 생략 가능. if 안에 들어온다면 컴파일러가 해당 타입 변환가능하다고 판단
        // ...
    }
}
```

#### Any, Unit, Nothing

##### Any

- Java 의 Object 와 대응 (모든 타입, 클래스의 최상위 타입)
- null 을 저장할수있는 타입이라면 Any? 로 표현 가능 

##### Unit

- Java 의 void 와 동일한 역할

##### Nothing

- 함수가 정상적으로 끝나지 않았다는 것을 표현하는 역할
- 무조건 예외를 반환하는 함수/ 무한루프 함수 등...

#### String

```kotlin
val student = Student("Jackson", 30)  // name : Jackson, age : 30
val log = "누규? ${student.name}, 몇짤? : ${student.age}"
```

- 문자열 내에 변수의 값을 표현하고 싶으면 `$`, `${}` 사용 가능

```kotlin
val str = """ 
            aaa
            bbb
            123
        """.trimIndent()

println(str)
/*  출력은 다음과 같음...
aaa
bbb
123
 */
```

- 큰 따옴표 3개로 감싸면 개행이 여러개 포함된 문자열을 편하게 표현 가능 

```kotlin
val str = "abcdefg"
val char = str[3] // d
```

- 배열을 참조하는 것 처럼 인덱스로 문자 획득 가능 

### 1.4. 연산자

#### ===, == (동일성, 동등성 비교)

- 기본적인 단항연산자, 산술연산자, 산술대입 연산자등은 모두 Java 와 동일 
- Kotlin 에서는 객체 비교연산자를 사용하여 비교가 가능한데, 이때 내부적으로 `compareTo()` 를 호출하여 비교 함

| Lang    | 인스턴스의 동일성 비교 | 의미한 값의 동등성 비교              |
|---------|--------------|----------------------------|
| Java    | `==`         | equals()                   |
| Kotlin  | `===`        | `==` 사용시 간접적으로 equals() 사용 |


```java
// [Java]

public class Money {
    private final long amount;
    public Money(long amount) { this.amount = amount; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }
}

// ...

public static void main(String [] args) {
    Money m1 = new Money(100);
    Money m2 = m1;
    Meney m3 = new Meney(100);
    
    System.out.println( m1 == m2 ); // true
    System.out.println( m1 == m3 ); // false 
    System.out.println( m1.equals(m3)); // true
}
```

```kotlin
  val m1 = Money(100L)
  val m2 = m1
  val m3 = Money(100L)

  println(m1 === m2)  // true
  println(m1 == m2)  // true - equals() 호출됨
  println(m1 == m3) // true - equals() 호출됨 
  println(m1 === m3) // false
```

#### 컬렉션이나 범위에 포함되어있는지 여부 확인 연산자

- `in` / `!in` 
  - 컬렉션이나 범위에 포함 / 미포함 
- `a..b`
  - a 부터 b 까지 범위 객체를 생성
- `a[i]`
  - a 에서 특정 인덱스로 값을 가져옴 (컬렉션, 문자열 등등)

## 2. 제어문

### 2.1. if 문

```kotlin
  if (...) {
      // ...
  } if else (...) {
      // ...
  } else {
      // ...
  }
```

- 기본적으로 완전 동일
- Statement : 프로그램 문장, 특정 값으로 리턴할 수 없음
- Expression : 특정한 하나의 값으로 리턴할 수 있음 

> Java 에서의 if-else 는 Statement <br>
> Kotlin 에서의 if-else 는 Expression

```kotlin

val score = if(grade == "A") 100 else 50

// ----

fun convertScore(x) {
    if (grade == "A") {
        return 100
    } else {
        return 50
    }
}

// ---

fun convertScore(x) {
  return if (grade == "A") {
     100
  } else {
     50
  }
}

// ---

fun convertScore(x) = if (grade == "A") 100 else 50
``` 
 
- Kotlin 에서는 위와 같이 if-else 이 Expression 라서 위와 같은 표현이 가능 

```kotlin
if (0 <= score && score <= 100) { 
    // ...
}

if (score in 0..100) {
    // .. 위와 동일 
}
```
- 범위의 조건 체크할때 위와 같은 방식 둘 다 가능 

```kotlin
if (score !in 0..100) {
    // .. 0 보다 작거나 100 보다 큰 조건..
}
```

### 2.2. switch, when

```kotlin
  when (score / 10) {
    10, 9 -> "A"
        8 -> "B"
        7 -> "C"
    else -> "F"
  }

  when (score) {
      in 90..100 -> "A"
      in 80..89  -> "B"
      in 70..79  -> "C"
      else -> "F"
  }
```

- switch 문 대신에 when 사용 
- 조건 체크하는 부분에는 enum, 값, in 연산자를포함한 어떠한 Expression 도 가능 (ex : is Type)
- if 와 동일하게 when 자체도 Expression 이라서 특정 변수에 대입도 가능. when 구절 앞에서 return 가능 

## 3. 반복문

### for-each

```java
// [Java]
List<Integer> numbers = Arrays.asList(10, 20, 30);
for (int number : numbers) {
    System.out.println(number);
}
```

```kotlin
// [Kotlin]
val numbers = listOf(10, 20, 30)
for (number in numbers) {  // in 뒤에는 iterable 이 구현된 타입이라면 모두 들어갈 수 있음 
    println(number)
}
```

### for 문 / Range / Progression

```java
// [Java]
for (int i=1; i<=3; i++) { // 1부터 3 까지
    System.out.println(i);    
}
```
```kotlin
// [Kotlin]
for (i in 1..3) { // 1부터 3 까지
    println(i)
}

for (i in 1..<3) { // 1부터 2 까지
  println(i)
}

for (i in 1..10 step 2) {
    println(i)  // 1 3 5 7 9
}

for (i in 3 downTo 1) { // 3 부터 1 까지 
    println(i)
}

for (i in 5 downTo 1 step 2) {
    println(i)  // 5 3 1
}
```

```kotlin
var i = 1
while (1 <= 3) {
    println(i)
  i++
}
```
- while 은 Java 와 동일 

[Range 와 Progression 관련 문서](https://kotlinlang.org/docs/ranges.html#progression)

## 4. 예외 다루기 

### try catch

```java
// [Java]
public int parseIntOrThrow(@NotNull String str) {
    try {
        return Integer.parseInt(str);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException(String.format("$s is NOT a number", str));
    }
}
```

```kotlin
// [Kotlin]
fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt() 
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("$str is NOT a number ")
    }
}
```
- 기본적인 사용법은 동일함 
- 참고 : 기본 타입간의 형변환은 각 Type Class 에 있는 메소드인 `toXXX()` 메소드를 사용

```kotlin
// [Kotlin]
fun parseIntOrThrow(str: String): Int? {
   return try {
       str.toInt()
   } catch (e: NumberFormatException) {
       null
   }
}
```

- Kotlin 에서는 try~catch 도 Expression 이라서 위와 같이 사용 가능  
- Kotlin 에서는 Checked Exception 도 모두 Unchecked Exception 처럼 취급.
- 따라서 별도로 throws 를 하거나 try~catch 를 강제하지 않아도 도미

### try with resources 

```java
public void readFile(String path) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
        System.out.println(bufferedReader.readLine()); 
    }
}
```
- 위 Java 메소드는 파일을 읽어 한줄 출력.
- 위와 같이 사용하면 `AutoClosable` 을 구현한 `BufferedReader` 객체는 알아서 `close()` 호출되어 정리됨 

```kotlin
fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}
```

- Kotlin 에는 try~with~resources 구문이 없음
- 유사하게 사용하고자 한다면 `use { }` 와 같은 확장함수를 사용해서 동일한 동작 가능

## 5. 함수 

### 함수 선언

```kotlin
// [Kotlin]
// 1)
public fun sum(a: Int, b: Int): Int {
    return a + b
}

// 2)
fun sum(a: Int, b: Int): Int {
	return a + b
} 

// 3)
fun sum(a: Int, b: Int) = a + b

```

- public 생략 가능. 생략하면 public 으로 선언됨
- 클래스 내부, 외부 선언가능. 한 파일안에 여러개 선언 가능  

### Parameter - Default argument

```kotlin
// [Kotlin]
fun repeatPrint(str: String, count: Int = 3, newLine: Boolean = true) {
    for (i in 1..count) {
        print(str)
        if (newLine) {
            println()
        }
    }
}
```

### Parameter - Named argument

```kotlin
// [Kotlin]
// 위의 함수를 호출. 단, count 는 default arg  를 사용하고 newLine 은 false 로 사용하고 싶다면
repeatPrint("Hello", newLine = false)
```
- 매개변수 이름을 통해 직접지정, 지정되지 않은 매개변수는 default arg 사용
- 해당 기능을 이용해 Builder 패턴을 구현할 수 있음
- 단, Java 의 함수를 호출하여 사용하고자하면 Named argument 를 사용할 수 없음

### 가변인자 파라미터

```java
// [Java]
public static void printAll(String... args) {
    for (String arg : args) {
        System.out.println(arg);
    }
}
```

- 배열을 통해 전달하거나, 각 args 를 직접 comma 로 구분하여 전달 가능

```kotlin
// [Kotlin]
fun printAll(vararg args: String) {
    for (arg in args) {
        println(arg)
    }
}

// ---
fun main() {
    printAll("aaa", "bbb", "ccc")
    val array = arrayOf("xxx", "yyy", "zzz")
    printAll(*array)  // spread operator
}
```

- `vararg` 키워드를 사용하여 가변인자 파라미터를 사용 가능
- 배열을 전달할때는 `*(spread operator)` 를 사용하여 전달