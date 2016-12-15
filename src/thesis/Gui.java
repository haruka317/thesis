package thesis;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Gui extends JFrame{
	//ウィンドウ本体
	public Gui(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1700, 1200);

		JButton btn1 = new JButton("開始");
		BevelBorder border1 = new BevelBorder(BevelBorder.RAISED);
		BevelBorder border2 = new BevelBorder(BevelBorder.LOWERED);

	    JPanel p1 = new JPanel();	//Map描画用パネル
	    p1.setBackground(Color.WHITE);
	    p1.setBounds(0, 0, 1100, 800);
	    p1.setBorder(border1);

	    JPanel p2 = new JPanel();	//パラメータ設定用パネル
	    p2.setBackground(Color.GRAY);
	    p2.setBounds(1400, 0, 300, 1200);
	    p2.setBorder(border2);




	    String[] city = {"北海道","青森県","岩手県","宮城県","秋田県","山形県",
	    		"福島県","茨城県","栃木県","群馬県","新潟県","富山県","石川県",
	    		"福井県","山梨県","長野県","岐阜県","静岡県","愛知県","三重県",
	    		"滋賀県","京都府","大阪府","兵庫県","奈良県","和歌山県","鳥取県",
	    		"島根県","岡山県","広島県","山口県","徳島県","香川県","愛媛県",
	    		"高知県","福岡県","佐賀県","長崎県","熊本県","大分県","宮崎県",
	    		"鹿児島県","沖縄県" };

	    JComboBox combo1 = new JComboBox();
	    combo1.setBounds(1300, 150, 200, 50);

	    JComboBox combo2 = new JComboBox(city);
	    combo2.setBounds(1300, 300, 200, 50);

		add(btn1);
		btn1.setBounds(1200,1000,400,75);
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("計算開始");
			}
		});

	    JLabel label1 = new JLabel("感染率=");
	    label1.setBounds(170, 880, 200, 50);

	    JTextField text1 = new JTextField(5);
	    text1.setBounds(230, 880, 200, 50);

	    JLabel label2 = new JLabel("回復率=");
	    label2.setBounds(170, 1030, 200, 50);

	    JTextField text2 = new JTextField(5);
	    text2.setBounds(230, 1030, 200, 50);

	    JLabel label3 = new JLabel("観察日数=");
	    label3.setBounds(620, 880, 200, 50);

	    JTextField text3 = new JTextField(5);
	    text3.setBounds(680, 880, 200, 50);

	    JLabel label4 = new JLabel("刻み幅=");
	    label4.setBounds(620, 1030, 200, 50);

	    JTextField text4 = new JTextField(5);
	    text4.setBounds(680, 1030, 200, 50);

	    Container contentPane = getContentPane();
	    contentPane.add(label1);
	    contentPane.add(text1);
	    contentPane.add(label2);
	    contentPane.add(text2);
	    contentPane.add(label3);
	    contentPane.add(text3);
	    contentPane.add(label4);
	    contentPane.add(text4);
	    contentPane.add(btn1);
	    contentPane.add(combo1);
	    contentPane.add(combo2);
	    contentPane.add(p1);
	    contentPane.add(p2);

		}
}
