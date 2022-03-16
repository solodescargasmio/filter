import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

class Factura{
    String descripcion;
    int precio;
    String codigoFactura;
    int cantidad;
    Date fechaFactura;
    Factura(String descripcion,int precio, String codigoFactura,int cantidad,Date fechaFactura){
        this.descripcion = descripcion;
        this.precio = precio;
        this.codigoFactura =  codigoFactura;
        this.cantidad = cantidad;
        this.fechaFactura = fechaFactura;
    }
    public int getImporte(){
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }
}
public class Main {

    public static void main(String[] args){
        Date fecha1 = new Date(123, 5,3);
        Date fecha2 = new Date(122, 2,21);
        Date fecha3 = new Date(122, 3,17);
        Date fecha4 = new Date(121, 12,8);

        Factura f= new Factura("ordenador",1000,"hml123",25,fecha1);
        Factura f2= new Factura("movil",300,"sms654",6,fecha2);
        Factura f3= new Factura("impresora",2000,"cl-310ii",35,fecha3);
        Factura f4= new Factura("imac",300,"iph582",98,fecha4);
        List<Factura> lista =new ArrayList<Factura>();

        lista.add(f);
        lista.add(f4);
        lista.add(f2);
        lista.add(f3);

        Predicate<Factura> predicate=new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
           return factura.getImporte()>300;
            }
        };
        Factura facturaFiltro=lista.stream()
                .filter(predicate).findFirst().get();
        System.out.println("Filtrado por Importe :"+facturaFiltro.getImporte()+" "+facturaFiltro.getCodigoFactura());
        Predicate<Factura> predicateFecha=new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getFechaFactura().before(fecha2);
            }
        };
        Factura filtroFecha=lista.stream()
                .filter(predicateFecha).findFirst().get();
        System.out.println("Filtrado por Fecha :"+filtroFecha.getFechaFactura()+"  "+filtroFecha.getCodigoFactura()+" "+filtroFecha.getImporte());

        Predicate<Factura> predicateCantidad=new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                //  throw new UnsupportedOperationException("no soprtado");
                return factura.getCantidad()<50;
            }
        };
        Factura filtroCantidad=lista.stream()
                .filter(predicateCantidad).findFirst().get();
        System.out.println("Filtrado por Cantidad :"+ filtroCantidad.getFechaFactura()+"  "+ filtroCantidad.getCodigoFactura()+" "+ filtroCantidad.getCantidad());

        Predicate<Factura> predicateCodigo=new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                //  throw new UnsupportedOperationException("no soprtado");
                return factura.getCodigoFactura().equals("sms654");
            }
        };
        Factura filtroCodigo=lista.stream()
                .filter(predicateCodigo).findFirst().get();
        System.out.println("Filtrado por Codigo :"+ filtroCodigo.getFechaFactura()+"  "+ filtroCodigo.getCodigoFactura()+" "+ filtroCodigo.getCantidad());


/*
        Factura facturaFiltro = lista.stream()
                                .filter(elemento->elemento.getImporte()>300)
                                .findFirst()
                                .get();


        System.out.println(facturaFiltro.getImporte());*/


    }

}
