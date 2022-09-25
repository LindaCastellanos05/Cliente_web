
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarGrado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarGrado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="grado" type="{http://services.soap.com/}modeloGrado" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarGrado", propOrder = {
    "grado"
})
public class ActualizarGrado {

    protected ModeloGrado grado;

    /**
     * Obtiene el valor de la propiedad grado.
     * 
     * @return
     *     possible object is
     *     {@link ModeloGrado }
     *     
     */
    public ModeloGrado getGrado() {
        return grado;
    }

    /**
     * Define el valor de la propiedad grado.
     * 
     * @param value
     *     allowed object is
     *     {@link ModeloGrado }
     *     
     */
    public void setGrado(ModeloGrado value) {
        this.grado = value;
    }

}
