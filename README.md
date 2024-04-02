# Java_CFT

**Тестовое задание (см. Java_TestTask.pdf)**

---
0. В задании, по-видимому, была допущена техническая опечатка, что в том числе подтверждается примером:
   
    «Целые числа в один выходной файл, **натуральные** в другой, строки в третий. По умолчанию файлы с результатами располагаются в текущей папке с именами integers.txt, floats.txt, strings.txt.».

    Поэтому, реализация задания была выполнена для такой постановки задачи:
    
    «Целые числа в один выходной файл, **вещественные** в другой, строки в третий. По умолчанию файлы с результатами располагаются в текущей папке с именами integers.txt, floats.txt, strings.txt.»


1. Приложение разработано на языке Java версии 17.


2. Использовалась система сборки apache-maven-3.9.6.


3. Использована библиотека аннотаций Lombok:
   ```
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
   ```
4. Использована библиотека для разбора параметров командной строки JCommander:
   ```
    <groupId>com.beust</groupId>
    <artifactId>jcommander</artifactId>
    <version>1.82</version>
   ```
    В случае передачи утилите некорректных параметров командной строки, приложение выводит предусмотренный шаблон параметров и завершает работу.


5. Реализация приложения придерживается принципов SOLID, что позволит с минимальными затратами «расширять» функционал приложения:
    - загружать данные не только с исходный файлов (БД, сеть, и т.д.)
    - сохранять данные не только в выходные файлы (БД, сеть, и т.д.)
    - произвольно «строить» цепочки фильтрации по любым типам данных.


6. Так как тестовое задание не накладывает ограничение на «размерность» целых и вещественных чисел входных данных, то текущая цепочка фильтрации «выстроена» как:
    ```
    input data => BigInteger -> Double -> String => output data
    ```
    Если конкретизировать «размерность» целых и вещественных чисел входных данных, то с целью увеличения производительности стоит «перестроить» цепочку фильтрации, например:
    ```
    input data => Integer -> Float -> String => output data
    ```
7. При запуске утилиты с опцией **-o** (задать путь для результатов), приложение **не создает** указанную папку, т.е. если папка отсутствует или путь для выходных файлов некорректен, приложение обрабатывает ошибку (выводит сообщение) и завершает работу.


8. Проект собирался в **IDEA** IDE, для сборки из командной строки предусмотрен **Makefile** с целями
   `build` и `run`. Для сборки проекта используется `maven-wrapper`.


9. Пример запуска утилиты:
   ```
   java -jar util.jar -s -f -p sample- in1.txt in2.txt
   ```
