
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para modeloNota complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="modeloNota"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id_alumno" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id_grado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id_notas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre_alumno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre_grado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nota1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="nota2" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="nota3" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="nota4" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modeloNota", propOrder = {
    "idAlumno",
    "idGrado",
    "idNotas",
    "nombreAlumno",
    "nombreGrado",
    "nota1",
    "nota2",
    "nota3",
    "nota4"
})
public class ModeloNota {

    @XmlElement(name = "id_alumno")
    protected int idAlumno;
    @XmlElement(name = "id_grado")
    protected int idGrado;
    @XmlElement(name = "id_notas")
    protected int idNotas;
    @XmlElement(name = "nombre_alumno")
    protected String nombreAlumno;
    @XmlElement(name = "nombre_grado")
    protected String nombreGrado;
    protected double nota1;
    protected double nota2;
    protected double nota3;
    protected double nota4;

    /**
     * Obtiene el valor de la propiedad idAlumno.
     * 
     */
    public int getIdAlumno() {
        return idAlumno;
    }

    /**
     * Define el valor de la propiedad idAlumno.
     * 
     */
    public void setIdAlumno(int value) {
        this.idAlumno = value;
    }

    /**
     * Obtiene el valor de la propiedad idGrado.
     * 
     */
    public int getIdGrado() {
        return idGrado;
    }

    /**
     * Define el valor de la propiedad idGrado.
     * 
     */
    public void setIdGrado(int value) {
        this.idGrado = value;
    }

    /**
     * Obtiene el valor de la propiedad idNotas.
     * 
     */
    public int getIdNotas() {
        return idNotas;
    }

    /**
     * Define el valor de la propiedad idNotas.
     * 
     */
    public void setIdNotas(int value) {
        this.idNotas = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAlumno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    /**
     * Define el valor de la propiedad nombreAlumno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAlumno(String value) {
        this.nombreAlumno = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreGrado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreGrado() {
        return nombreGrado;
    }

    /**
     * Define el valor de la propiedad nombreGrado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreGrado(String value) {
        this.nombreGrado = value;
    }

    /**
     * Obtiene el valor de la propiedad nota1.
     * 
     */
    public double getNota1() {
        return nota1;
    }

    /**
     * Define el valor de la propiedad nota1.
     * 
     */
    public void setNota1(double value) {
        this.nota1 = value;
    }

    /**
     * Obtiene el valor de la propiedad nota2.
     * 
     */
    public double getNota2() {
        return nota2;
    }

    /**
     * Define el valor de la propiedad nota2.
     * 
     */
    public void setNota2(double value) {
        this.nota2 = value;
    }

    /**
     * Obtiene el valor de la propiedad nota3.
     * 
     */
    public double getNota3() {
        return nota3;
    }

    /**
     * Define el valor de la propiedad nota3.
     * 
     */
    public void setNota3(double value) {
        this.nota3 = value;
    }

    /**
     * Obtiene el valor de la propiedad nota4.
     * 
     */
    public double getNota4() {
        return nota4;
    }

    /**
     * Define el valor de la propiedad nota4.
     * 
     */
    public void setNota4(double value) {
        this.nota4 = value;
    }

}
