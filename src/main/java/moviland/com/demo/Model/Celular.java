package moviland.com.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "Celular")
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "pantalla(In)", nullable = false)
    private Float pantalla;

    @Column(name = "bateria(mah)", nullable = false)
    private Float bateria;

    @Column(name = "s.o.", nullable = false)
    private String sistemaOperativo;

    @Column(name = "camara(MP)", nullable = false)
    private Float camara;

    @Column(name = "almacenamiento(GB)", nullable = false)
    private Long almacenamiento;

    @Column(name = "img (link)", nullable = false)
    private String imagen;

    @Column(name = "Precio", nullable = false)
    private Float precio;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public Celular() {
    }

    public Celular(int id, String marca, String nombre, Integer stock, Float pantalla, Float bateria,
            String sistemaOperativo, Float camara, Long almacenamiento, String imagen, Float precio, Boolean estado) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.stock = stock;
        this.pantalla = pantalla;
        this.bateria = bateria;
        this.sistemaOperativo = sistemaOperativo;
        this.camara = camara;
        this.almacenamiento = almacenamiento;
        this.imagen = imagen;
        this.precio = precio;
        this.estado = estado;
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Float getPantalla() {
        return pantalla;
    }

    public void setPantalla(Float pantalla) {
        this.pantalla = pantalla;
    }

    public Float getBateria() {
        return bateria;
    }

    public void setBateria(Float bateria) {
        this.bateria = bateria;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Float getCamara() {
        return camara;
    }

    public void setCamara(Float camara) {
        this.camara = camara;
    }

    public Long getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(Long almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    // Otras anotaciones, relaciones, métodos, etc., según tus necesidades
}
