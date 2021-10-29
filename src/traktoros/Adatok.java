package traktoros;

import java.util.ArrayList;

import datastorage.DbFunctions;
import pojo.Gyorsulas;
import pojo.Potkocsi;
import pojo.Szlalom;
import pojo.Versenyzo;

public class Adatok {
	private ArrayList<Potkocsi> potkocsis;
	private ArrayList<Szlalom> szlalom;
	private ArrayList<Gyorsulas> gyorsulas;

	private ArrayList<Versenyzo> sza;
	private ArrayList<Versenyzo> szf;
	private ArrayList<Versenyzo> gya;
	private ArrayList<Versenyzo> gyf;
	private ArrayList<Versenyzo> pka;
	private ArrayList<Versenyzo> pkf;
	private ArrayList<Versenyzo> no;
	private ArrayList<Versenyzo> vet;
	@SuppressWarnings("unused")
	private ArrayList<Versenyzo> sortedsza;
	@SuppressWarnings("unused")
	private ArrayList<Versenyzo> sortedszf;
	@SuppressWarnings("unused")
	private ArrayList<Versenyzo> sortedgyf;
	@SuppressWarnings("unused")
	private ArrayList<Versenyzo> sortedgya;
	@SuppressWarnings("unused")
	private ArrayList<Versenyzo> sortedpka;
	@SuppressWarnings("unused")
	private ArrayList<Versenyzo> sortedpkf;
	@SuppressWarnings("unused")
	private ArrayList<Versenyzo> sortedno;
	@SuppressWarnings("unused")
	private ArrayList<Versenyzo> sortedvet;
	private ArrayList<Versenyzo> temp;
	private ArrayList<Versenyzo> paros;
	private ArrayList<Versenyzo> paratlan;

	public Adatok() {

	}

	public ArrayList<Potkocsi> getPotkocsis() {
		return potkocsis;
	}

	public void setPotkocsis(ArrayList<Potkocsi> potkocsis) {
		this.potkocsis = potkocsis;
	}

	public ArrayList<Szlalom> getSzlalom() {
		return szlalom;
	}

	public void setSzlalom(ArrayList<Szlalom> szlalom) {
		this.szlalom = szlalom;
	}

	public ArrayList<Gyorsulas> getGyorsulas() {
		return gyorsulas;
	}

	public void setGyorsulas(ArrayList<Gyorsulas> gyorsulas) {
		this.gyorsulas = gyorsulas;
	}

	public ArrayList<Versenyzo> merger(ArrayList<Versenyzo> lista) {
		temp = new ArrayList<Versenyzo>();

		paros = new ArrayList<Versenyzo>();
		paratlan = new ArrayList<Versenyzo>();

		Versenyzo ures = new Versenyzo("senki", 0, "", "");

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getRajt() % 2 == 0) {
				paros.add(lista.get(i));
			} else {
				paratlan.add(lista.get(i));
			}
		}

		boolean stop = false;
		int j = 1;
		while (!stop) {
			if (j % 2 == 0) {
				if (paros.size() > 0) {
					temp.add(paros.get(0));
					paros.remove(0);
				} else {
					// temp.add(ures);
					if (paratlan.size() > 0) {
						temp.add(paratlan.get(0));
						paratlan.remove(0);
					} else {
						temp.add(ures);
					}

				}
			} else {
				if (paratlan.size() > 0) {
					temp.add(paratlan.get(0));
					paratlan.remove(0);
				} else {
					// temp.add(ures);
					if (paros.size() > 0) {
						temp.add(paros.get(0));
						paros.remove(0);
					} else {
						temp.add(ures);
					}

				}
			}

			j++;

			if (paros.size() == 0 && paratlan.size() == 0) {
				stop = true;
			}
		}

		return temp;
	}

	public void generateRajtlista(boolean button) {
		ArrayList<Versenyzo> lista = new DbFunctions().selectAdat();
		sza = new ArrayList<Versenyzo>();
		szf = new ArrayList<Versenyzo>();
		gya = new ArrayList<Versenyzo>();
		gyf = new ArrayList<Versenyzo>();
		pka = new ArrayList<Versenyzo>();
		pkf = new ArrayList<Versenyzo>();

		sortedsza = new ArrayList<Versenyzo>();
		sortedszf = new ArrayList<Versenyzo>();
		sortedgyf = new ArrayList<Versenyzo>();
		sortedgya = new ArrayList<Versenyzo>();
		sortedpka = new ArrayList<Versenyzo>();
		sortedpkf = new ArrayList<Versenyzo>();

		Versenyzo v;

		for (int i = 0; i < lista.size(); i++) {
			v = lista.get(i);

			if (v.getNeme().equals("No")) {
				no.add(v);
			} else if (!v.getNeme().equals("No") && v.getKategoria().equals("veteran")) {
				vet.add(v);
			} else if (!v.getNeme().equals("No") && !v.getKategoria().equals("veteran") && v.getKategoria().equals("150a")) {
				System.out.println(v.getRajt());
				if (v.getPotkocsis().equals("true"))
					pka.add(v);
				if (v.getSzlalom().equals("true"))
					sza.add(v);
				if (v.getGyorsulas().equals("true"))
					gya.add(v);
			} else {
				if (v.getPotkocsis().equals("true"))
					pkf.add(v);
				if (v.getSzlalom().equals("true"))
					szf.add(v);
				if (v.getGyorsulas().equals("true"))
					gyf.add(v);
			}
/*
			if (v.getNeme().equals("No") || v.getKategoria().equals("150a") || v.getKategoria().equals("veteran")) {
				if (v.getPotkocsis().equals("true"))
					pka.add(v);
				if (v.getSzlalom().equals("true"))
					sza.add(v);
				if (v.getGyorsulas().equals("true"))
					gya.add(v);
			} else {
				if (v.getPotkocsis().equals("true"))
					pkf.add(v);
				if (v.getSzlalom().equals("true"))
					szf.add(v);
				if (v.getGyorsulas().equals("true"))
					gyf.add(v);
			}
			*/
		}

		sortedpka = merger(pka);
		sortedpkf = merger(pkf);
		sortedsza = merger(sza);
		sortedszf = merger(szf);
		sortedgya = merger(gya);
		sortedgyf = merger(gyf);

		sortedno = merger(no);
		sortedvet = merger(vet);

		/*
		 * rajtlistapanel.setData(sortedpka, sortedpkf, sortedsza, sortedszf,
		 * sortedgya, sortedgyf); if (button) { rajtlistapanel.setVisible(true);
		 * }
		 */
	}
}
