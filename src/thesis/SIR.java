package thesis;

import java.util.ArrayList;

public class SIR {
	double h;	//刻み幅
	double t;	//観察期間
	static ArrayList<City> pc = new ArrayList<City>();	//processing = TrueのCityコレクション

	City c;
	Virus v;


	public SIR(City c,Virus v){
		//c:感染源
		this.h = 1;
		this.t = 200;

		this.c = c;
		this.v = v;
	}

	public void calc(){
		pc.add(c);
		c.s = 1 - v.i;
		c.i = v.i;
		//for(double k = 0; k < t; k += h){
			/*for(ArrayList<City> cc; pc){
			}*/
				c.s = c.s + (h/6)*(c.k1[0] + 2*c.k2[0] + 2*c.k3[0] + c.k4[0]);
				c.i = c.i + (h/6)*(c.k1[1] + 2*c.k2[1] + 2*c.k3[1] + c.k4[1]);
				//r = r + (h/6)*(k1[2] + 2*k2[2] + 2*k3[2] + k4[2]);
				c.r = Math.max(0,1 - ( c.s + c.i ));
				c.S = (int) (c.s*c.pop);
				c.I = (int) (c.i*c.pop);
				c.R = c.pop - (c.S + c.I);
				System.out.printf("%8d|%8d|%8d\n",c.S,c.I,c.R);

				c.k1[0] = dS(c.s,c.i,c.r,t);
				c.k1[1] = dI(c.s,c.i,c.r,t);
				c.k1[2] = dR(c.s,c.i,c.r,t);

				c.k2[0] = dS(c.s+(h/2)*c.k1[0],
									c.i+(h/2)*c.k1[0],
									c.r+(h/2)*c.k1[0],
									t+(h/2));
				c.k2[1] = dI(c.s+(h/2)*c.k1[1],
									c.i+(h/2)*c.k1[1],
									c.r+(h/2)*c.k1[1],
									t+(h/2));
				c.k2[2] = dR(c.s+(h/2)*c.k1[2],
									c.i+(h/2)*c.k1[2],
									c.r+(h/2)*c.k1[2],
									t+(h/2));

				c.k3[0] = dS(c.s+(h/2)*c.k2[0],
									c.i+(h/2)*c.k2[0],
									c.r+(h/2)*c.k2[0],
									t+(h/2));
				c.k3[1] = dI(c.s+(h/2)*c.k2[1],
									c.i+(h/2)*c.k2[1],
									c.r+(h/2)*c.k2[1],
									t+(h/2));
				c.k3[2] = dR(c.s+(h/2)*c.k2[2],
									c.i+(h/2)*c.k2[2],
									c.r+(h/2)*c.k2[2],
									t+(h/2));

				c.k4[0] = dS(c.s+(h/2)*c.k3[0],
									c.i+(h/2)*c.k3[0],
									c.r+(h/2)*c.k3[0],
									t+(h/2));
				c.k4[1] = dI(c.s+(h/2)*c.k3[1],
									c.i+(h/2)*c.k3[1],
									c.r+(h/2)*c.k3[1],
									t+(h/2));
				c.k4[2] = dR(c.s+(h/2)*c.k3[2],
									c.i+(h/2)*c.k3[2],
									c.r+(h/2)*c.k3[2],
									t+(h/2));

					//System.out.println(City.cc.get(c.nc[3]).name);

				/*
				 * processing = trueにするかどうかの処理
				 * 確率はiRに格納される(予定)
				 * if文で確率的な処理を行う
				 */

				/*
				 * processing = trueを持つものをpcに追加していく処理
				 */


	//	}
	}

	public double dS(double s,double i,double r,double t){
		return -v.b*s*i;
	}

	public double dI(double s,double i,double r,double t){
		return v.b*s*i - v.g*i;
	}

	public double dR(double s,double i,double r,double t){
		return v.g*i;
	}
}