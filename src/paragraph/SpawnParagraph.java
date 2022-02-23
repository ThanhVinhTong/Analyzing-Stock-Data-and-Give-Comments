package paragraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import sentence.BanRaMuaLai;
import sentence.ChotPhien;
import sentence.CoPhieuChungKhoan;
import sentence.CoPhieuNoiBat;
import sentence.DacTinhNoiBat;
import sentence.DuBan;
import sentence.DuMua;
import sentence.DungGia;
import sentence.GiaoDichLon;
import sentence.Hot;
import sentence.KhoiNgoai;
import sentence.Sentence;
import sentence.ShortTerm;
import sentence.TangTran;
import sentence.ThanhKhoan;
import sentence.TinhTrang;
import sentence.TongGiaTriGiaoDich;
import sentence.KyLuc;
import sentence.LongTerm;
import sentence.NhaDauTuNuocNgoai;
import sentence.PennyMidCap;
import sentence.TyLeLon;
import sentence.TyLeThap;

public class SpawnParagraph{
	
	private Sentence sen ;
	
	protected ArrayList<String> listOfTag = new ArrayList<String>();
	protected ArrayList<String> listOfSentence = new ArrayList<String>();
	
	private File myObj = new File("D://Games//Java//Stock//src//data//inputData.txt");
	private File myObj1 = new File("D://Games//Java//Stock//src//data//TagStatus.txt");
	
	public SpawnParagraph() throws IOException {
		
		sen = new Sentence();
		BanRaMuaLai brml = new BanRaMuaLai();
		ChotPhien cp = new ChotPhien();
		CoPhieuChungKhoan cpck = new CoPhieuChungKhoan();
		CoPhieuNoiBat cpnb = new CoPhieuNoiBat();
		GiaoDichLon gdl = new GiaoDichLon();
		Hot h = new Hot();
		TyLeLon tll = new TyLeLon();
		TyLeThap tlt = new TyLeThap();
		KyLuc kl = new KyLuc();
		LongTerm lt = new LongTerm();
		ShortTerm st = new ShortTerm();
		TinhTrang tt = new TinhTrang();
		DacTinhNoiBat dtnb = new DacTinhNoiBat();
		KhoiNgoai kn = new KhoiNgoai();
		PennyMidCap pmc = new PennyMidCap();
		ThanhKhoan tk = new ThanhKhoan();
		NhaDauTuNuocNgoai ndtnn = new NhaDauTuNuocNgoai();
		DuBan db = new DuBan();
		DuMua dm = new DuMua();
		DungGia dg = new DungGia();
		TangTran ttr = new TangTran();
		TongGiaTriGiaoDich tgtgd = new TongGiaTriGiaoDich();
		
		sen.setSentence(brml.getFileString());
		sen.setSentence(cp.getFileString());
		sen.setSentence(cpck.getFileString());
		sen.setSentence(cpnb.getFileString());
		sen.setSentence(gdl.getFileString());
		sen.setSentence(h.getFileString());
		sen.setSentence(tll.getFileString());
		sen.setSentence(tlt.getFileString());
		sen.setSentence(kl.getFileString());
		sen.setSentence(lt.getFileString()); 
		sen.setSentence(st.getFileString());
		sen.setSentence(tt.getFileString());
		sen.setSentence(dtnb.getFileString());
		sen.setSentence(kn.getFileString());
		sen.setSentence(pmc.getFileString());
		sen.setSentence(tk.getFileString());
		sen.setSentence(ndtnn.getFileString());
		sen.setSentence(db.getFileString());
		sen.setSentence(dm.getFileString());
		sen.setSentence(dg.getFileString());
		sen.setSentence(ttr.getFileString());
		sen.setSentence(tgtgd.getFileString());
		
		try {
			BufferedReader in = new BufferedReader(
					   new InputStreamReader(
			                      new FileInputStream(myObj), "UTF8"));
			String s = in.readLine();
			if (s!=null) {
				String[] tempString = s.split(" ");
				for (int i=0;i<tempString.length;i++) {
					listOfTag.add(tempString[i]);
				}
			}
			in.close();
			
			BufferedReader in1 = new BufferedReader(
					   new InputStreamReader(
			                      new FileInputStream(myObj1), "UTF8"));
			String s1 = in1.readLine();
				if (s1!=null) {
					String[] tempString1 = s1.split(" ");
					for (int i=0;i<tempString1.length;i++) {
						listOfTag.add(tempString1[i]);
					}
			}
			in1.close();
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	public ArrayList<String> getSentence(){
		return listOfSentence;
	}
	
	public void filterTag() {
		int [] check = new int[sen.getSentence().size()];
		int [] pos = new int[sen.getSentence().size()];
		for (int i=0;i<sen.getSentence().size();i++) {
			pos[i]=i;
		}
		
		for (String i:sen.getSentence()) {
			for (String j: listOfTag) {
				if (i.contains(j)) {
					check[sen.getSentence().indexOf(i)]++;
				}
			}
		}
		
		sort(check,pos);
		for (int i=0;i<pos.length;i++) {
			if (check[i]>0) {
				listOfSentence.add(sen.getSentence().get(pos[i]));
			}
		}
	}
	
	public void sort(int a[],int b[]) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[j] > a[i]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					temp = b[j];
					b[j] = b[i];
					b[i] = temp;
				}
			}
		}
	}
}