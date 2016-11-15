package thesis;

public class Virus {
	//int id;			//VirusごとのID
	String name;	//ウイルス名
	double b;		//感染率
	double g;		//除外率
	double i; 		//初期感染者数
	//static int count = 1;	//ID数をカウント

	public Virus(){
		//this.id = count;
		this.name = "インフル";
		this.b = 0.45;
		this.g = 1/3.5;
		this.i = 0.001;
		//count++;
	}

	public Virus(String name, double b, double g){
		//this.id = count;
		this.name = name;
		this.b = b;
		this.g = g;
		//count++;
	}
}


