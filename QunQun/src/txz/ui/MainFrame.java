package txz.ui;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.crypto.ShortBufferException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//�̳�Frame��
public class MainFrame extends Frame implements KeyListener{
	public MainFrame(){
		//������
		targetInt();
		 //����
		 wolfInt();
		 //����
		sheepInt();
		//����
		treeInt();
		 //��������������ӵ�������
		 backgroundInit();
		//������������
		 setMainFrameUI();
		 //�ô��ڼල�ǲ��� ���˼���
		 this.addKeyListener(this);
	}
	JLabel[][] sheeps= new JLabel [16][12];
	int[][] datas={
			{1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,1,1,1,0,1,0,0,1},
			{1,0,0,0,1,0,1,0,1,0,0,1},
			{1,0,0,0,1,0,1,1,1,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1}
	};
	int a;
	int b;
	int num=0;
	int total=3;
	private void treeInt() {
		Icon w=new ImageIcon("2.png");
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if (datas[i][j]==1) {
				JLabel lab_tree= new JLabel(w);
				lab_tree.setBounds(8+50*i, 30+50*j, 50, 50);
				this.add(lab_tree);
				}
		    }
		 }
	}	
	private void targetInt() {
		Icon i=new ImageIcon("8.png");
		JLabel lab_t1= new JLabel(i);
		lab_t1.setBounds(708, 330, 50, 50);
		this.add(lab_t1);
		JLabel lab_t2= new JLabel(i);
		lab_t2.setBounds(708,380, 50,50);
		this.add(lab_t2);
		JLabel lab_t3= new JLabel(i);
		lab_t3.setBounds(708,430, 50,50);
		this.add(lab_t3);
	}
	private void sheepInt() {
		//����һ�����ӵ�ͼƬ
		Icon i=new ImageIcon("4.png");
		JLabel lab_sheep1= new JLabel(i);
		lab_sheep1.setBounds(308, 380, 50, 50);
		this.add(lab_sheep1);
		datas[6][7]=4;
		sheeps[6][7]=lab_sheep1;
		//�����ڶ�ֻ��
		JLabel lab_sheep2= new JLabel(i);
		lab_sheep2.setBounds(308, 280, 50, 50);
		this.add(lab_sheep2);
		datas[6][5]=4;
		sheeps[6][5]=lab_sheep2;
		JLabel lab_sheep3= new JLabel(i);
		lab_sheep3.setBounds(308, 180, 50, 50);
		this.add(lab_sheep3);
		datas[6][3]=4;
		sheeps[6][3]=lab_sheep3;
	}
	//������ʼ��
	private void backgroundInit() {
		//���ʵ�ֱ�����
		//ʹ��JLabel����
		//����һ��ͼƬ
	    Icon i =new ImageIcon("floor.png");
		JLabel lab_bg= new JLabel(i);
		//���ó��ֵ�λ��
		lab_bg.setBounds(8, 30, 800, 600);
		//�����ͼ��ӵ����壬���������һ������
		this.add(lab_bg);
	}
	//���������������ʾЧ��
	private void setMainFrameUI(){
		//������������Ĳ���ģʽΪ���ɲ���
	   this.setLayout(null);
	   this.setTitle("������ v1.0");
	   this.setSize(810, 640);
	   this.setLocation(400, 100);
	   this.setVisible(true);	
	}
	private void wolfInt() {
		a=4;
		b=6;
		Icon i= new ImageIcon("-10.png");
	    lab_wolf= new JLabel(i);
	    //datas[4][6]=2;
		lab_wolf.setBounds(8+a*50, 30+b*50, 50, 50);
		this.add(lab_wolf);
	}
	JLabel lab_wolf;
	public void keyTyped(KeyEvent e) {
				}
	public void keyPressed(KeyEvent e) {
	}
	private void victory() {
		if (num==total) {
			System.out.println("��ӡʤ��");
		}
	}
	public void keyReleased(KeyEvent e) {
		int key =e.getKeyCode();
		if (key==39) {
			//�����ƶ��������ϵ�һλ����a+1
			if (datas[a+1][b]==0) {
				a=a+1;
				//�����������ƶ�
				int x=(int) lab_wolf.getLocation().getX();
				int y=(int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x+50,y);
				Icon i= new ImageIcon("1.png");
				lab_wolf.setIcon(i);
				return;
			}
			if (datas[a+1][b]==1) {
				return;
			}
			if (datas[a+1][b]==4 && datas[a+2][b]==1) {
				return;
			}
			if (datas[a+1][b]==4 && datas[a+2][b]==4) {
				return;
			}
			if (datas[a+1][b]==4 && datas[a+2][b]==12) {
				return;
			}
			if (datas[a+1][b]==12 && datas[a+2][b]==1) {
				return;
			}
			if (datas[a+1][b]==12 && datas[a+2][b]==4) {
				return;
			}
			if (datas[a+1][b]==12 && datas[a+2][b]==12) {
				return;
			}
			if (datas[a+1][b]==8) {
				a=a+1;
				//�����������ƶ�
				int x=(int) lab_wolf.getLocation().getX();
				int y=(int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x+50,y);
				Icon i= new ImageIcon("1.png");
				lab_wolf.setIcon(i);
				return;
			}
			if (datas[a+1][b]==4 && datas[a+2][b]==0) {
				datas[a+1][b]=0;
				datas[a+2][b]=4;
			}
			if (datas[a+1][b]==4 && datas[a+2][b]==8) {
				datas[a+1][b]=0;
				datas[a+2][b]=12;
				num++;
			}
			if (datas[a+1][b]==12 && datas[a+2][b]==0) {
				datas[a+1][b]=8;
				datas[a+2][b]=4;
				num--;
			}
			if (datas[a+1][b]==12 && datas[a+2][b]==8) {
				datas[a+1][b]=8;
				datas[a+2][b]=12;
			}
			sheeps[a+1][b].setLocation(8+a*50+100,30+b*50);
			sheeps[a+2][b]=sheeps[a+1][b];
			sheeps[a+1][b]=null;
			a=a+1;
			int x=(int) lab_wolf.getLocation().getX();
			int y=(int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x+50,y);
			Icon i= new ImageIcon("1.png");
			lab_wolf.setIcon(i);
			victory();
			return;
		}
		if (key==37) {
			if (datas[a-1][b]==0) {
				a=a-1;
				//�����������ƶ�
				int x=(int) lab_wolf.getLocation().getX();
				int y=(int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x-50,y);
				Icon i= new ImageIcon("01.png");
				lab_wolf.setIcon(i);
				return;
			}
			if (datas[a-1][b]==1) {
				return;
			}
			if (datas[a-1][b]==4 && datas[a-2][b]==1) {
				return;
			}
			if (datas[a-1][b]==4 && datas[a-2][b]==4) {
				return;
			}
			if (datas[a-1][b]==4 && datas[a-2][b]==12) {
				return;
			}
			if (datas[a-1][b]==12 && datas[a-2][b]==1) {
				return;
			}
			if (datas[a-1][b]==12 && datas[a-2][b]==4) {
				return;
			}
			if (datas[a-1][b]==12 && datas[a-2][b]==12) {
				return;
			}
			if (datas[a-1][b]==8) {
				a=a-1;
				int x=(int) lab_wolf.getLocation().getX();
				int y=(int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x-50,y);
				Icon i= new ImageIcon("01.png");
				lab_wolf.setIcon(i);
				return;
			}
			if (datas[a-1][b]==4 && datas[a-2][b]==0) {
				datas[a-1][b]=0;
				datas[a-2][b]=4;
			}
			if (datas[a-1][b]==4 && datas[a-2][b]==8) {
				datas[a-1][b]=0;
				datas[a-2][b]=12;
				num++;
			}
			if (datas[a-1][b]==12 && datas[a-2][b]==0) {
				datas[a-1][b]=8;
				datas[a-2][b]=4;
				num--;
			}
			if (datas[a-1][b]==12 && datas[a-2][b]==8) {
				datas[a-1][b]=8;
				datas[a-2][b]=12;
			}
			sheeps[a-1][b].setLocation(8+a*50-100,30+b*50);
			sheeps[a-2][b]=sheeps[a-1][b];
			sheeps[a-1][b]=null;
			a=a-1;
			int x=(int) lab_wolf.getLocation().getX();
			int y=(int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x-50,y);
			Icon i= new ImageIcon("01.png");
			lab_wolf.setIcon(i);
			victory();
			return;
		}
		if (key==38) {
			if (datas[a][b-1]==0) {
				b=b-1;
				//�����������ƶ�
				int x=(int) lab_wolf.getLocation().getX();
				int y=(int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x,y-50);
				Icon i= new ImageIcon("10.png");
				lab_wolf.setIcon(i);
				return;
			}
			if (datas[a][b-1]==1) {
				return;
			}
			if (datas[a][b-1]==4 && datas[a][b-2]==1) {
				return;
			}
			if (datas[a][b-1]==4 && datas[a][b-2]==4) {
				return;
			}
			if (datas[a][b-1]==4 && datas[a][b-2]==12) {
				return;
			}
			if (datas[a][b-1]==12 && datas[a][b-2]==1) {
				return;
			}
			if (datas[a][b-1]==12 && datas[a][b-2]==4) {
				return;
			}
			if (datas[a][b-1]==12 && datas[a][b-2]==12) {
				return;
			}
			if (datas[a][b-1]==8) {
				b=b-1;
				int x=(int) lab_wolf.getLocation().getX();
				int y=(int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x,y-50);
				Icon i= new ImageIcon("10.png");
				lab_wolf.setIcon(i);
				return;
			}
			if (datas[a][b-1]==4 && datas[a][b-2]==0) {
				datas[a][b-1]=0;
				datas[a][b-2]=4;
			}
			if (datas[a][b-1]==4 && datas[a][b-2]==8) {
				datas[a][b-1]=0;
				datas[a][b-2]=12;
				num++;
			}
			if (datas[a][b-1]==12 && datas[a][b-2]==0) {
				datas[a][b-1]=8;
				datas[a][b-2]=4;
				num--;
			}
			if (datas[a][b-1]==12 && datas[a][b-1]==8) {
				datas[a][b-1]=8;
				datas[a][b-2]=12;
			}
			sheeps[a][b-1].setLocation(8+a*50,30+b*50-100);
			sheeps[a][b-2]=sheeps[a][b-1];
			sheeps[a][b-1]=null;
			b=b-1;
			int x=(int) lab_wolf.getLocation().getX();
			int y=(int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x,y-50);
			Icon i= new ImageIcon("10.png");
			lab_wolf.setIcon(i);
			victory();
			return;
		}
		if (key==40) {
			if (datas[a][b+1]==0) {
				b=b+1;
				//�����������ƶ�
				int x=(int) lab_wolf.getLocation().getX();
				int y=(int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x,y+50);
				Icon i= new ImageIcon("-10.png");
				lab_wolf.setIcon(i);
				return;
			}
			if (datas[a][b+1]==1) {
				return;
			}
			if (datas[a][b+1]==4 && datas[a][b+2]==1) {
				return;
			}
			if (datas[a][b+1]==4 && datas[a][b+2]==4) {
				return;
			}
			if (datas[a][b+1]==4 && datas[a][b+2]==12) {
				return;
			}
			if (datas[a][b+1]==12 && datas[a][b+2]==1) {
				return;
			}
			if (datas[a][b+1]==12 && datas[a][b+2]==4) {
				return;
			}
			if (datas[a][b+1]==12 && datas[a][b+2]==12) {
				return;
			}
			if (datas[a][b+1]==8) {
				b=b+1;
				int x=(int) lab_wolf.getLocation().getX();
				int y=(int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x,y+50);
				Icon i= new ImageIcon("-10.png");
				lab_wolf.setIcon(i);
				return;
			}
			if (datas[a][b+1]==4 && datas[a][b+2]==0) {
				datas[a][b+1]=0;
				datas[a][b+2]=4;
			}
			if (datas[a][b+1]==4 && datas[a][b+2]==8) {
				datas[a][b+1]=0;
				datas[a][b+2]=12;
				num++;
			}
			if (datas[a][b+1]==12 && datas[a][b+2]==0) {
				datas[a][b+1]=8;
				datas[a][b+2]=4;
				num--;
			}
			if (datas[a][b+1]==12 && datas[a][b+1]==8) {
				datas[a][b+1]=8;
				datas[a][b+2]=12;
			}
			sheeps[a][b+1].setLocation(8+a*50,30+b*50+100);
			sheeps[a][b+2]=sheeps[a][b+1];
			sheeps[a][b+1]=null;
			b=b+1;
			int x=(int) lab_wolf.getLocation().getX();
			int y=(int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x,y+50);
			Icon i= new ImageIcon("-10.png");
			lab_wolf.setIcon(i);
			victory();
			return;
		}
	}
	}