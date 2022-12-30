import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Studentクラスのコンストラクタを使用し、リストを作成。
public class StudentList {
    public static void main(String[] args) {

        List<Student> list = List.of(
                new Student("suzuki",180,"A"),
                new Student("konnno",170,"A"),
                new Student("saitou",158,"B"),
                new Student("tajima",165,"O"),
                new Student("yamaguchi",148,"B"),
                new Student("suzuki",153,"O"));

        //nameの文字列に"s"を含む要素を取り出す
        List<Student> nameList = list.stream().filter(n->n.getName().contains("s")).collect(Collectors.toList());
        System.out.println(nameList);

        //heightが160以上の値を持つ要素を取り出す
        List<Student> heightList = list.stream().filter(n->n.getHeight() >= 160).collect(Collectors.toList());
        System.out.println(heightList);

        //血液型でグルーピング
        Map<String, List<Student>> bloodTypeToStudents = list.stream() //グループの変数名はkeyToValue かvalueByKeyのような形式が良い
                .collect(Collectors.groupingBy(Student::getBloodType));

        //bloodTypeToStudents.entrySet()を使用して、Mapオブジェクトのエントリを取得
        //forEachを使用して、取得したエントリをそれぞれ処理
        //entryを使用して、エントリからキーを取得し、System.out.printlnを使用して標準出力に出力
        bloodTypeToStudents.entrySet().forEach(entry -> {
            System.out.println("血液型が" + entry.getKey() + "型の生徒: " + entry.getValue());
        });
    }
}
