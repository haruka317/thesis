package thesis;

public class Virus {
	String name;	//ウイルス名
	double b;		//感染率
	double g;		//除外率
	double i; 		//初期感染者数

	public Virus(){
		this.name = "インフル";
		this.b = 0.45;
		this.g = 1/3.5;
		this.i = 0.001;
	}

	public Virus(String name, double b, double g){
		this.name = name;
		this.b = b;
		this.g = g;
	}
}


