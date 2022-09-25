
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para modeloGrado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="modeloGrado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descripcion_grado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id_grado" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modeloGrado", propOrder = {
    "descripcionGrado",
    "idGrado"
})
public class ModeloGrado {

    @XmlElement(name = "descripcion_grado")
    protected String descripcionGrado;
    @XmlElement(name = "id_grado")
    protected int idGrado;

    /**
     * Obtiene el valor de la propiedad descripcionGrado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionGrado() {
        return descripcionGrado;
    }

    /**
     * Define el valor de la propiedad descripcionGrado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionGrado(String value) {
        this.descripcionGrado = value;
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

}
