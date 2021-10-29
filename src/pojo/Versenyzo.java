package pojo;

public class Versenyzo {
	private String nev;
	private int rajt;
	private String varos;
	private String osztozik;
	private String kategoria;
	private String neme;
	private String potkocsis;
	private String szlalom;
	private String gyorsulas;
	private String erohuzas;

	public Versenyzo() {
		nev = varos = osztozik = kategoria = neme = potkocsis = szlalom = gyorsulas = erohuzas = "";
	}

	public Versenyzo(String n, int nu, String p, String c) {
		setNev(n);
		setRajt(nu);
		setOsztozik(p);
	}

	public String getNev() {
		return nev;
	}

	public int getRajt() {
		return rajt;
	}

	public void setNev(String name) {
		this.nev = name;
	}

	public void setRajt(int number) {
		this.rajt = number;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String category) {
		this.kategoria = category;
	}

	public String getOsztozik() {
		return osztozik;
	}

	public void setOsztozik(String plate) {
		this.osztozik = plate;
	}

	public String getPotkocsis() {
		return potkocsis;
	}

	public void setPotkocsis(String potkocsis) {
		this.potkocsis = potkocsis;
	}

	public String getGyorsulas() {
		return gyorsulas;
	}

	public void setGyorsulas(String gyorsulas) {
		this.gyorsulas = gyorsulas;
	}

	public String getNeme() {
		return neme;
	}

	public void setNeme(String neme) {
		this.neme = neme;
	}

	public String getSzlalom() {
		return szlalom;
	}

	public void setSzlalom(String szlalom) {
		this.szlalom = szlalom;
	}

	public String getVaros() {
		return varos;
	}

	public void setVaros(String varos) {
		this.varos = varos;
	}
	
	public String getErohuzas() {
		//System.out.println("erõhúzás kérés " + erohuzas);
		return erohuzas;
	}

	public void setErohuzas(String erohuzas) {
		this.erohuzas = erohuzas;
	}
}
