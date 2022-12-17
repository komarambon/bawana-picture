package dto;

import java.sql.Date;

import jakarta.persistence.Id;

public class BookingDto {

	@Id
	private String transactionCode;
	private String name;
	private String namaPackage;
	private String namaProduct;
	private Integer harga;
	private Date tglFoto;
	private String lokasiFoto;
	private String namePaymentmethod;
	
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNamaPackage() {
		return namaPackage;
	}
	public void setNamaPackage(String namaPackage) {
		this.namaPackage = namaPackage;
	}
	public String getNamaProduct() {
		return namaProduct;
	}
	public void setNamaProduct(String namaProduct) {
		this.namaProduct = namaProduct;
	}
	public Integer getHarga() {
		return harga;
	}
	public void setHarga(Integer harga) {
		this.harga = harga;
	}
	public Date getTglFoto() {
		return tglFoto;
	}
	public void setTglFoto(Date tglFoto) {
		this.tglFoto = tglFoto;
	}
	public String getLokasiFoto() {
		return lokasiFoto;
	}
	public void setLokasiFoto(String lokasiFoto) {
		this.lokasiFoto = lokasiFoto;
	}
	public String getNamePaymentmethod() {
		return namePaymentmethod;
	}
	public void setNamePaymentmethod(String namePaymentmethod) {
		this.namePaymentmethod = namePaymentmethod;
	}
	
}

	