
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para eliminarNota complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="eliminarNota"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id_alumno" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
@XmlType(name = "eliminarNota", propOrder = {
    "idAlumno",
    "idGrado"
})
public class EliminarNota {

    @XmlElement(name = "id_alumno")
    protected int idAlumno;
    @XmlElement(name = "id_grado")
    protected int idGrado;

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

}
