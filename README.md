1. Брагина Наталья Дмитриевна
2. Интерфейс содержит только объявления методов и константы (final static поля), тогда как абстракный класс может содержать поля, методы с реализацией (в том числе и приватные). Начиная с Java 8 интерфейсы могут содержать реализацию методов по умолчанию, что делает их похожими на интерфейсы, однако ограничение на поля и приватные методы остаются.
3. System.gc()
4. Тогда, когда требуется вызвать метод, не объявленный в супер классе у объекта, объявленноготчерез ссылку на супер класс. В качестве примера можно привести реализацию метода equals(Object o). удостоверившись, что переданный обект подходящего типа, мы приводим его к этому типу, а затем уже сравниваем нужные поля.
5. Конструкторы не возвращают значений, вызывваются для создания объекта. Если в конструкторе произошло исключение, обънект создан не будет.
6. Да. Это часто применяют для инициализации нескольких полей класса. Сначала пишут конструктор с наибольшим числом параметров, затем прочие, с меньшим числом параметров, в теле которых вызываются уже написанные конструкторы со значениями по умолчанию для полей, не вошедших в список параметров.
7. JDK - Java Development Kit содержит набор библиотек Java, компилятор и виртуальную машину, а так же ряд утилит для разработки. JRE - Java Runtime Invironment содержит виртуальную машину и набор библиотек.
8. Имеет. FileNotFoundException - подкласс IOExceptipon, следовательно если IOExceptipon перехватывать первым, то FileNotFoundException также будет перехвачен в этом блоке, и следующий блок, перехватывающий FileNotFoundException будет недостижим.
9. Да. Они так же будут иметь доступ ко всем полям внешнего класса.
10. Через ключевое слово super, которое содержит ссылку на объект суперкласса.
11. Очередь - список, добавление элементов в котором идет с конца, а выборка сначала. Стек - список, добавление и выборка элементов в котором идет с конца.
12. По статистике большинство объектов в Java становятся ненужными практически сразу после их создания и лишь немногие остаются живы на протяжении долгого времени. По этой причине JVM делит память на две неравные части, в одной (меньшей) хранит новые объекты - Joung generation, в другой старые объекты - Old generation. Сборка мусора в первой части осуществляется гораздо бюыстрее. Объект переходит в Old generation, если он пережил хотя бы один цикл сборки мусора.
13. 
