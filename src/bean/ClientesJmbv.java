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
 * ClientesJmbv generated by hbm2java
 */
@Entity
@Table(name="clientes_jmbv"
    ,catalog="db_joao_vilhanueva"
)
public class ClientesJmbv  implements java.io.Serializable {


     private int idclientesJmbv;
     private String nomeJmbv;
     private String sexoJmbv;
     private Date dataNascimentoJmbv;
     private String contatoJmbv;
     private String cpfJmbv;
     private String cepJmbv;
     private String enderecoJmbv;
     private String numeroJmbv;
     private String cidadeJmbv;
     private String bairroJmbv;
     private String complementoJmbv;
     private String estadoJmbv;
     private String emailJmbv;
     private String rgJmbv;

    public ClientesJmbv() {
    }

	
    public ClientesJmbv(int idclientesJmbv, String nomeJmbv, String sexoJmbv, Date dataNascimentoJmbv, String contatoJmbv, String cpfJmbv, String cepJmbv, String enderecoJmbv, String numeroJmbv, String cidadeJmbv, String bairroJmbv, String estadoJmbv, String emailJmbv, String rgJmbv) {
        this.idclientesJmbv = idclientesJmbv;
        this.nomeJmbv = nomeJmbv;
        this.sexoJmbv = sexoJmbv;
        this.dataNascimentoJmbv = dataNascimentoJmbv;
        this.contatoJmbv = contatoJmbv;
        this.cpfJmbv = cpfJmbv;
        this.cepJmbv = cepJmbv;
        this.enderecoJmbv = enderecoJmbv;
        this.numeroJmbv = numeroJmbv;
        this.cidadeJmbv = cidadeJmbv;
        this.bairroJmbv = bairroJmbv;
        this.estadoJmbv = estadoJmbv;
        this.emailJmbv = emailJmbv;
        this.rgJmbv = rgJmbv;
    }
    public ClientesJmbv(int idclientesJmbv, String nomeJmbv, String sexoJmbv, Date dataNascimentoJmbv, String contatoJmbv, String cpfJmbv, String cepJmbv, String enderecoJmbv, String numeroJmbv, String cidadeJmbv, String bairroJmbv, String complementoJmbv, String estadoJmbv, String emailJmbv, String rgJmbv) {
       this.idclientesJmbv = idclientesJmbv;
       this.nomeJmbv = nomeJmbv;
       this.sexoJmbv = sexoJmbv;
       this.dataNascimentoJmbv = dataNascimentoJmbv;
       this.contatoJmbv = contatoJmbv;
       this.cpfJmbv = cpfJmbv;
       this.cepJmbv = cepJmbv;
       this.enderecoJmbv = enderecoJmbv;
       this.numeroJmbv = numeroJmbv;
       this.cidadeJmbv = cidadeJmbv;
       this.bairroJmbv = bairroJmbv;
       this.complementoJmbv = complementoJmbv;
       this.estadoJmbv = estadoJmbv;
       this.emailJmbv = emailJmbv;
       this.rgJmbv = rgJmbv;
    }
   
     @Id 

    
    @Column(name="idclientes_jmbv", unique=true, nullable=false)
    public int getIdclientesJmbv() {
        return this.idclientesJmbv;
    }
    
    public void setIdclientesJmbv(int idclientesJmbv) {
        this.idclientesJmbv = idclientesJmbv;
    }

    
    @Column(name="nome_jmbv", nullable=false, length=70)
    public String getNomeJmbv() {
        return this.nomeJmbv;
    }
    
    public void setNomeJmbv(String nomeJmbv) {
        this.nomeJmbv = nomeJmbv;
    }

    
    @Column(name="sexo_jmbv", nullable=false, length=1)
    public String getSexoJmbv() {
        return this.sexoJmbv;
    }
    
    public void setSexoJmbv(String sexoJmbv) {
        this.sexoJmbv = sexoJmbv;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataNascimento_jmbv", nullable=false, length=10)
    public Date getDataNascimentoJmbv() {
        return this.dataNascimentoJmbv;
    }
    
    public void setDataNascimentoJmbv(Date dataNascimentoJmbv) {
        this.dataNascimentoJmbv = dataNascimentoJmbv;
    }

    
    @Column(name="contato_jmbv", nullable=false, length=30)
    public String getContatoJmbv() {
        return this.contatoJmbv;
    }
    
    public void setContatoJmbv(String contatoJmbv) {
        this.contatoJmbv = contatoJmbv;
    }

    
    @Column(name="cpf_jmbv", nullable=false, length=12)
    public String getCpfJmbv() {
        return this.cpfJmbv;
    }
    
    public void setCpfJmbv(String cpfJmbv) {
        this.cpfJmbv = cpfJmbv;
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

    
    @Column(name="numero_jmbv", nullable=false, length=16)
    public String getNumeroJmbv() {
        return this.numeroJmbv;
    }
    
    public void setNumeroJmbv(String numeroJmbv) {
        this.numeroJmbv = numeroJmbv;
    }

    
    @Column(name="cidade_jmbv", nullable=false, length=45)
    public String getCidadeJmbv() {
        return this.cidadeJmbv;
    }
    
    public void setCidadeJmbv(String cidadeJmbv) {
        this.cidadeJmbv = cidadeJmbv;
    }

    
    @Column(name="bairro_jmbv", nullable=false, length=20)
    public String getBairroJmbv() {
        return this.bairroJmbv;
    }
    
    public void setBairroJmbv(String bairroJmbv) {
        this.bairroJmbv = bairroJmbv;
    }

    
    @Column(name="complemento_jmbv", length=20)
    public String getComplementoJmbv() {
        return this.complementoJmbv;
    }
    
    public void setComplementoJmbv(String complementoJmbv) {
        this.complementoJmbv = complementoJmbv;
    }

    
    @Column(name="estado_jmbv", nullable=false, length=25)
    public String getEstadoJmbv() {
        return this.estadoJmbv;
    }
    
    public void setEstadoJmbv(String estadoJmbv) {
        this.estadoJmbv = estadoJmbv;
    }

    
    @Column(name="email_jmbv", nullable=false, length=30)
    public String getEmailJmbv() {
        return this.emailJmbv;
    }
    
    public void setEmailJmbv(String emailJmbv) {
        this.emailJmbv = emailJmbv;
    }

    
    @Column(name="rg_jmbv", nullable=false, length=14)
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


