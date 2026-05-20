async function cargarXML(ruta) {
    const response = await fetch(ruta);
    if (!response.ok) throw new Error("No se pudo cargar: " + ruta);
    const texto = await response.text();
    return new window.DOMParser().parseFromString(texto, "text/xml");
}

async function transformar(xmlPath, xslPath) {
    const xml = await cargarXML(xmlPath);
    const xsl = await cargarXML(xslPath);

    const processor = new XSLTProcessor();
    processor.importStylesheet(xsl);

    
    return processor.transformToDocument(xml);
}

function descargarArchivo(contenido, nombre, tipo) {
    const blob = new Blob([contenido], { type: tipo });
    const enlace = document.createElement("a");
    enlace.href = URL.createObjectURL(blob);
    enlace.download = nombre;
    enlace.click();
    URL.revokeObjectURL(enlace.href);
}

async function descargarHTML() {
    try {
        const resultado = await transformar("Inventario.xml", "Inventario-HTML.xml");
        const serializer = new XMLSerializer();
        const html = serializer.serializeToString(resultado);
        descargarArchivo(html, "informe-inventario.html", "text/html");
    } catch (error) {
        alert("Error generando HTML: " + error);
    }
}

async function descargarCSV() {
    try {
        const xml = await cargarXML("Inventario.xml");
        const xsl = await cargarXML("Inventario-CSV.xml");

        const processor = new XSLTProcessor();
        processor.importStylesheet(xsl);

        const fragmento = processor.transformToFragment(xml, document);
        const csv = fragmento.textContent.trim(); 

        descargarArchivo(csv, "inventario.csv", "text/csv");
    } catch (error) {
        alert("Error generando CSV: " + error);
    }
}
