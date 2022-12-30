public class Student {
    //リストに複数の要素（今回は文字列の名前、数字の身長の２つの要素を持たせたい。）
    //ここで作成したクラスをStudentListクラスで使用
    private final String name; //名前
    private final int height; //身長
    private final String bloodType ; //血液型

    public Student(String name, int height, String bloodType) {
        this.name = name;
        this.height = height;
        this.bloodType = bloodType;
    }

    public String getName() {return name;}
    public int getHeight() {return height;}
    public String getBloodType() {return bloodType;}


    //「Student」クラスを表示するときに「name」フィールドや「height」フィールドの値を知りたい場合は「toString」メソッドをオーバーライドして、それらの値を含む文字列を返すようにする。
    //「toString」メソッドは、オブジェクトを文字列に変換するメソッド。Javaでは、オブジェクトを直接出力する場合、「toString」メソッドが呼び出され、その戻り値が出力。
        @Override
        public String toString() {
            return "Student(名前：" + name + ", 身長：" + height + ". 血液型:" + bloodType +"型)";
        }
}
