import java.util.*;
import java.util.stream.Collectors;

public class CafeMenu {
    public static void main(String[] args) {
        //コーヒーのメニューのリスト
        ArrayList<String> menuLists = new ArrayList<>(Arrays.asList("ブラックコーヒー","カフェモカ","ホワイトモカ","キャラメルコーヒー"));
        //値段のリスト
        ArrayList<Integer> priceLists = new ArrayList<>(Arrays.asList(420, 520, 480, 620));
        //コーヒーのオプション
        ArrayList<String> option = new ArrayList<>(Arrays.asList("sugar","milk","gum syrup","chocolate"));

        //拡張for文を使用してのリスト内のモカの文字列を持つ要素の抽出
        ArrayList<String> mocha = new ArrayList<>();
        for (String menuList : menuLists) {
            if (menuList.contains("モカ")) {
                mocha.add(menuList);
            }
        }
        System.out.println(mocha);

        //StreamAPIを使用してコーヒーの文字列を含む要素の抽出
        List<String> coffee = menuLists.stream().filter(s -> s.contains("コーヒー")).toList();
        System.out.println(coffee);

        //StreamAPIを使用して500以上の値を含む要素の抽出
        List<Integer> highPrice = priceLists.stream().filter(s -> s >= 500).toList();
        System.out.println(highPrice);

        option.stream()
                .map(String::toUpperCase) //toUpperCase()で大文字に
                .sorted() //ストリーム内の要素をアルファベット順に
                .limit(3) //limitで最初の3つの要素を取得
                .forEach(System.out::println); //forEachでストリーム内の要素をそれぞれ取り出し、System.out.printlnを使用して標準出力に出力。

        //minとmaxの引数は、比較に用いられるインターフェースのComparator、戻り値は、Optionalを用いる。
        Optional<Integer> minPrice  = priceLists.stream().min(Comparator.naturalOrder());//最小の値の取得
        System.out.println(minPrice.get());

        Optional<Integer> maxPrice = priceLists.stream().max(Comparator.naturalOrder());
        System.out.println(maxPrice.get());

        //文字列を区切り文字で連結し、指定された接頭辞と接尾辞等を付加
        List<String> str = Arrays.asList("one", "two", "three","four");
        String results = str.stream().collect(Collectors.joining("-","[","]"));
        System.out.println(results);
    }
}
