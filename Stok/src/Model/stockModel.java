package Model;



public class stockModel {
	
	
	private String _stokKodu;
	private String _stokAdi;
	private Integer _stokTipi;
	private String _birim;
	private String _barkod;
	private Double _kdvTipi; 
	private String _aciklama;
	private String _tarih;
	
	
	public stockModel(String _stokKodu, String _stokAdi, Integer _stokTipi, String _birim, String _barkod,
			Double _kdvTipi, String _aciklama, String _tarih) {	
		this._stokKodu = _stokKodu;
		this._stokAdi = _stokAdi;
		this._stokTipi = _stokTipi;
		this._birim = _birim;
		this._barkod = _barkod;
		this._kdvTipi = _kdvTipi;
		this._aciklama = _aciklama;
		this._tarih = _tarih;
	}
	public stockModel(String _stokKodu) {
		this._stokKodu = _stokKodu;
	}
	
	public String get_stokKodu() {
		return _stokKodu;
	}
	public void set_stokKodu(String _stokKodu) {
		this._stokKodu = _stokKodu;
	}
	public String get_StokAdi() {
		return _stokAdi;
	}
	public void set_StokAdi(String _stokAdi) {
		this._stokAdi = _stokAdi;
	}
	public Integer get_stokTipi() {
		return _stokTipi;
	}
	public void set_stokTipi(Integer _stokTipi) {
		this._stokTipi = _stokTipi;
	}
	public String get_birim() {
		return _birim;
	}
	public void set_birim(String _birim) {
		this._birim = _birim;
	}
	public String get_barkod() {
		return _barkod;
	}
	public void set_barkod(String _barkod) {
		this._barkod = _barkod;
	}
	public Double get_kdvTipi() {
		return _kdvTipi;
	}
	public void set_kdvTipi(Double _kdvTipi) {
		this._kdvTipi = _kdvTipi;
	}
	public String get_aciklama() {
		return _aciklama;
	}
	public void set_aciklama(String _aciklama) {
		this._aciklama = _aciklama;
	}
	public String get_tarih() {
		return _tarih;
	}
	public void set_tarih(String tarih) {
		this._tarih = tarih;
	}	
	

  
	
}
