package thesis;

import java.util.Arrays;
import java.util.HashMap;

public class City {
	int id;			//CityごとのID
	int pop; //人口
	int S;		//感受性保持者
	int I;		//感染者
	int R;	//除外者

	int[] nc;		//隣接都市IDの配列

	String name;	//都市名

	double s;		//感受性保持者率
	double i;		//感染者率
	double r;		//除外者率

	double[] mR;	//隣接都市への移動率
	double[] iR; 	//隣接都市への感染率(i*moveRate)
	double[] k1;	//Runge-Kutta法の係数格納用配列
	double[] k2;	//Runge-Kutta法の係数格納用配列
	double[] k3;	//Runge-Kutta法の係数格納用配列
	double[] k4;	//Runge-Kutta法の係数格納用配列

	boolean processing = false; //SIRモデルが開始されているか否か

	static int count = 1;	//ID数をカウント

	public static HashMap<Integer, City> cc = new HashMap<Integer, City>();
	/*
	ArrayList<Integer> sc ;	//感受性者数の推移を格納する配列
	ArrayList<Integer> ic ;	//感染者数の推移を格納する配列
	ArrayList<Integer> rc ;	//回復者数の推移を格納する配列
	*/

	/*
	 * Cityクラスのコンストラクタ
	 */
	public City(String str, int s, int a[]){
		this.id = count;
		this.pop = s;

		this.nc = a;

		this.name = str;

		this.s = 1;
		this.i = 0.00000;
		this.r = 0.00;

		this.mR = new double[nc.length];
		Arrays.fill(a, 1/(nc.length));
		this.iR = new double[nc.length];

		this.k1 = new double[3];
		this.k2 = new double[3];
		this.k3 = new double[3];
		this.k4 = new double[3];
		/*
		this.sc = new ArrayList<Integer>();
		this.ic = new ArrayList<Integer>();
		this.rc = new ArrayList<Integer>();
		*/
		cc.put(id, this);	//idとクラスを関連付けてHashMapに格納
		count++;
	}
}
