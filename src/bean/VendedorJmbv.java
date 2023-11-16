package bean;
// Generated 14/11/2023 18:30:52 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VendedorJmbv generated by hbm2java
 */
@Entity
@Table(name="vendedor_jmbv"
    ,catalog="db_joao_vilhanueva"
)
public class VendedorJmbv  implements java.io.Serializable {


     private int idvendedorJmbv;
     private String nomeJmbv;
     private String cpfJmbv;
     private Date dataNascimentoJmbv;
     private String cepJmbv;
     private String enderecoJmbv;
     private String numeroJmbv;
     private String bairroJmbv;
     private String complementoJmbv;
     private String emailJmbv;
     private String rgJmbv;

    public VendedorJmbv() {
    }

	
    public VendedorJmbv(int idvendedorJmbv, String nomeJmbv, String cpfJmbv, Date dataNascimentoJmbv, String cepJmbv, String enderecoJmbv, String numeroJmbv, String bairroJmbv, String emailJmbv, String rgJmbv) {
        this.idvendedorJmbv = idvendedorJmbv;
        this.nomeJmbv = nomeJmbv;
        this.cpfJmbv = cpfJmbv;
        this.dataNascimentoJmbv = dataNascimentoJmbv;
        this.cepJmbv = cepJmbv;
        this.enderecoJmbv = enderecoJmbv;
        this.numeroJmbv = numeroJmbv;
        this.bairroJmbv = bairroJmbv;
        this.emailJmbv = emailJmbv;
        this.rgJmbv = rgJmbv;
    }
    public VendedorJmbv(int idvendedorJmbv, String nomeJmbv, String cpfJmbv, Date dataNascimentoJmbv, String cepJmbv, String enderecoJmbv, String numeroJmbv, String bairroJmbv, String complementoJmbv, String emailJmbv, String rgJmbv) {
       this.idvendedorJmbv = idvendedorJmbv;
       this.nomeJmbv = nomeJmbv;
       this.cpfJmbv = cpfJmbv;
       this.dataNascimentoJmbv = dataNascimentoJmbv;
       this.cepJmbv = cepJmbv;
       this.enderecoJmbv = enderecoJmbv;
       this.numeroJmbv = numeroJmbv;
       this.bairroJmbv = bairroJmbv;
       this.complementoJmbv = complementoJmbv;
       this.emailJmbv = emailJmbv;
       this.rgJmbv = rgJmbv;
    }
   
     @Id 

    
    @Column(name="idvendedor_jmbv", unique=true, nullable=false)
    public int getIdvendedorJmbv() {
        return this.idvendedorJmbv;
    }
    
    public void setIdvendedorJmbv(int idvendedorJmbv) {
        this.idvendedorJmbv = idvendedorJmbv;
    }

    
    @Column(name="nome_jmbv", nullable=false, length=50)
    public String getNomeJmbv() {
        return this.nomeJmbv;
    }
    
    public void setNomeJmbv(String nomeJmbv) {
        this.nomeJmbv = nomeJmbv;
    }

    
    @Column(name="cpf_jmbv", nullable=false, length=14)
    public String getCpfJmbv() {
        return this.cpfJmbv;
    }
    
    public void setCpfJmbv(String cpfJmbv) {
        this.cpfJmbv = cpfJmbv;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataNascimento_jmbv", nullable=false, length=10)
    public Date getDataNascimentoJmbv() {
        return this.dataNascimentoJmbv;
    }
    
    public void setDataNascimentoJmbv(Date dataNascimentoJmbv) {
        this.dataNascimentoJmbv = dataNascimentoJmbv;
    }

    
    @Column(name="cep_jmbv", nullable=false, length=9)
    public String getCepJmbv() {
        return this.cepJmbv;
    }
    
    public void setCepJmbv(String cepJmbv) {
        this.cepJmbv = cepJmbv;
    }

    
    @Column(name="endereco_jmbv", nullable=false, length=70)
    public String getEnderecoJmbv() {
        return this.enderecoJmbv;
    }
    
    public void setEnderecoJmbv(String enderecoJmbv) {
        this.enderecoJmbv = enderecoJmbv;
    }

    
    @Column(name="numero_jmbv", nullable=false, length=13)
    public String getNumeroJmbv() {
        return this.numeroJmbv;
    }
    
    public void setNumeroJmbv(String numeroJmbv) {
        this.numeroJmbv = numeroJmbv;
    }

    
    @Column(name="bairro_jmbv", nullable=false, length=20)
    public String getBairroJmbv() {
        return this.bairroJmbv;
    }
    
    public void setBairroJmbv(String bairroJmbv) {
        this.bairroJmbv = bairroJmbv;
    }

    
    @Column(name="complemento_jmbv", length=40)
    public String getComplementoJmbv() {
        return this.complementoJmbv;
    }
    
    public void setComplementoJmbv(String complementoJmbv) {
        this.complementoJmbv = complementoJmbv;
    }

    
    @Column(name="email_jmbv", nullable=false, length=30)
    public String getEmailJmbv() {
        return this.emailJmbv;
    }
    
    public void setEmailJmbv(String emailJmbv) {
        this.emailJmbv = emailJmbv;
    }

    
    @Column(name="rg_jmbv", nullable=false, length=12)
    public String getRgJmbv() {
        return this.rgJmbv;
    }
    
    public void setRgJmbv(String rgJmbv) {
        this.rgJmbv = rgJmbv;
    }



@Override
public String toString() {
return this.nomeJmbv;
}


}


