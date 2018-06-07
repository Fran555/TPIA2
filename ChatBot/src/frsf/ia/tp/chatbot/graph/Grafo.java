package frsf.ia.tp.chatbot.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase que implementa el grafo utilizado en la búsqueda.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Grafo {

	static LinkedList<NodoG> listaNodos = cargarNodos();
	static LinkedList<Arco> listaArcos  = cargarArcos();
	
	/**
	 * Metodo que carga la lista de los nodos, con sus respectivas
	 * reglas y etiquetas.
	 * @return La lista de nodos.
	 */
	public static LinkedList<NodoG> cargarNodos(){
		
		//Se crean los nodos
		LinkedList<NodoG> lista= new LinkedList<NodoG>();		
		NodoG hola=new NodoG();
		hola.setEtiqueta("hola");
		lista.add(hola);		
		NodoG donde=new NodoG();
		donde.setEtiqueta("donde");
		lista.add(donde);		
		NodoG que=new NodoG();
		que.setEtiqueta("que");
		lista.add(que);		
		NodoG chau=new NodoG();
		chau.setEtiqueta("chau");
		lista.add(chau);		
		NodoG gracias=new NodoG();
		gracias.setEtiqueta("gracias");
		lista.add(gracias);		
		NodoG estar=new NodoG();
		estar.setEtiqueta("estar");
		lista.add(estar);		
		NodoG final1=new NodoG();
		final1.setEtiqueta("final");
		lista.add(final1);		
		NodoG informar=new NodoG();
		informar.setEtiqueta("informar");
		lista.add(informar);		
		NodoG grupo=new NodoG();
		grupo.setEtiqueta("grupo");
		lista.add(grupo);		
		NodoG conformar=new NodoG();
		conformar.setEtiqueta("conformar");
		lista.add(conformar);		
		NodoG organizar=new NodoG();
		organizar.setEtiqueta("organizar");
		lista.add(organizar);		
		NodoG regularizar=new NodoG();
		regularizar.setEtiqueta("regularizar");
		lista.add(regularizar);		
		NodoG ir=new NodoG();
		ir.setEtiqueta("ir");
		lista.add(ir);		
		NodoG como=new NodoG();
		como.setEtiqueta("como");
		lista.add(como);		
		NodoG nota=new NodoG();
		nota.setEtiqueta("nota");
		lista.add(nota);		
		NodoG cuantas=new NodoG();
		cuantas.setEtiqueta("cuantas");
		lista.add(cuantas);		
		NodoG entregar=new NodoG();
		entregar.setEtiqueta("entregar");
		lista.add(entregar);		
		NodoG objetivo=new NodoG();
		objetivo.setEtiqueta("objetivo");
		lista.add(objetivo);		
		NodoG promocionar=new NodoG();
		promocionar.setEtiqueta("promocionar");
		lista.add(promocionar);		
		NodoG calcular=new NodoG();
		calcular.setEtiqueta("calcular");
		lista.add(calcular);		
		NodoG materia=new NodoG();
		materia.setEtiqueta("materia");
		lista.add(materia);		
		NodoG actividad=new NodoG();
		actividad.setEtiqueta("actividad");
		lista.add(actividad);		
		NodoG cuando=new NodoG();
		cuando.setEtiqueta("cuando");
		lista.add(cuando);		
		NodoG realizar=new NodoG();
		realizar.setEtiqueta("realizar");
		lista.add(realizar);		
		NodoG evaluar=new NodoG();
		evaluar.setEtiqueta("evaluar");
		lista.add(evaluar);		
		NodoG sitio=new NodoG();
		sitio.setEtiqueta("sitio");
		lista.add(sitio);		
		NodoG apunte=new NodoG();
		apunte.setEtiqueta("apunte");
		lista.add(apunte);		
		NodoG tp=new NodoG();
		tp.setEtiqueta("tp");
		lista.add(tp);		
		NodoG mail=new NodoG();
		mail.setEtiqueta("mail");
		lista.add(mail);		
		NodoG fecha=new NodoG();
		fecha.setEtiqueta("fecha");
		lista.add(fecha);		
		NodoG aprobar=new NodoG();
		aprobar.setEtiqueta("aprobar");
		lista.add(aprobar);		
		NodoG charla=new NodoG();
		charla.setEtiqueta("charla");
		lista.add(charla);		
		NodoG coloquio=new NodoG();
		coloquio.setEtiqueta("coloquio");
		lista.add(coloquio);		
		NodoG ser=new NodoG();
		ser.setEtiqueta("ser");
		lista.add(ser);		
		NodoG framework=new NodoG();
		framework.setEtiqueta("framework");
		lista.add(framework);		
		NodoG llamar=new NodoG();
		llamar.setEtiqueta("llamar");
		lista.add(llamar);		
		NodoG agente=new NodoG();
		agente.setEtiqueta("agente");
		lista.add(agente);		
		NodoG tema=new NodoG();
		tema.setEtiqueta("tema");
		lista.add(tema);		
		NodoG cual=new NodoG();
		cual.setEtiqueta("cual");
		lista.add(cual);		
		NodoG recuperatorio=new NodoG();
		recuperatorio.setEtiqueta("recuperatorio");
		lista.add(recuperatorio);		
		NodoG modalidad=new NodoG();
		modalidad.setEtiqueta("modalidad");
		lista.add(modalidad);		
		NodoG quien=new NodoG();
		quien.setEtiqueta("quien");
		lista.add(quien);		
		NodoG parcial=new NodoG();
		parcial.setEtiqueta("parcial");
		lista.add(parcial);		
		NodoG libro=new NodoG();
		libro.setEtiqueta("libro");
		lista.add(libro);		
		NodoG asistencia=new NodoG();
		asistencia.setEtiqueta("asistencia");
		lista.add(asistencia);		
		NodoG porcentaje=new NodoG();
		porcentaje.setEtiqueta("porcentaje");
		lista.add(porcentaje);		
		NodoG bibliografia=new NodoG();
		bibliografia.setEtiqueta("bibliografia");
		lista.add(bibliografia);		
		NodoG clase=new NodoG();
		clase.setEtiqueta("clase");
		lista.add(clase);
		NodoG profesor=new NodoG();
		profesor.setEtiqueta("profesor");
		lista.add(profesor);		
		NodoG profesora=new NodoG();
		profesora.setEtiqueta("profesora");
		lista.add(profesora);		
		NodoG ayudante=new NodoG();
		ayudante.setEtiqueta("ayudante");
		lista.add(ayudante);		
		NodoG horario=new NodoG();
		horario.setEtiqueta("horario");
		lista.add(horario);		
		NodoG practica=new NodoG();
		practica.setEtiqueta("practica");
		lista.add(practica);		
		NodoG teoria=new NodoG();
		teoria.setEtiqueta("teoria");
		lista.add(teoria);		
		NodoG consulta=new NodoG();
		consulta.setEtiqueta("consulta");
		lista.add(consulta);
		
		//Se crean las reglas.
		Regla r1 = new Regla(1,1,0,0,"","Auch…no te entendí, me repetís la pregunta? :)");
		Regla r2=new Regla(2,1,0,0,"","No se que decirte, no entendí la pregunta :S");				
		Regla r3=new Regla(3,1,3,0,"hola","Hola!!!");
		Regla r4=new Regla(4,1,1,0,"hola","Buenas...");		
		Regla r5=new Regla(5,2,3,0,"como llamar","Andrés, pero me dicen ANDU…vos?");
		Regla r6=new Regla(6,2,1,0,"como llamar","Andrés, y tu nombre es…?");		
		Regla r97=new Regla(97,2,3,0,"quien ser","Andrés, pero me dicen ANDU…vos?");
		Regla r8=new Regla(8,2,1,0,"quien ser","Me llamo Andrés, me dicen ANDU. Vos quién sos?");				
		Regla r98=new Regla(98,3,3,0,"cual ser llamar","Andrés, y tu nombre es…?");				
		Regla r7=new Regla(7,3,1,0,"cual ser llamar","Andrés, el tuyo?");		
		Regla r9=new Regla(9,2,1,0,"como estar","Todo bien!, y vos?");
		Regla r10=new Regla(10,2,1,0,"como estar","Bien bien :)");
		Regla r11=new Regla(11,2,1,0,"como estar","Joya :) vos que tal?");
		Regla r12=new Regla(12,2,1,0,"como estar","Espectacular, vos que tal estas?");				
		Regla r99=new Regla(99,2,1,0,"que estar","Todo bien!, y vos?");
		Regla r100=new Regla(100,2,1,0,"que estar","Bien bien :)");
		Regla r101=new Regla(101,2,1,0,"que estar","Joya :) vos que tal?");
		Regla r102=new Regla(102,2,1,0,"que estar","Espectacular, vos que tal estas?");				
		Regla r103=new Regla(103,2,1,0,"que ir","Todo bien!, y vos?");
		Regla r104=new Regla(104,2,1,0,"que ir","Bien bien :)");
		Regla r105=new Regla(105,2,1,0,"que ir","Joya :) vos que tal?");
		Regla r106=new Regla(106,2,1,0,"que ir","Espectacular, vos que tal estas?");		
		Regla r13=new Regla(13,2,1,0,"que realizar","No mucho…ando chateando un poco para despejarme de las cosas de la facu");
		Regla r14=new Regla(14,2,3,0,"que realizar","Estudiando IA…a ver si logro entender lo que estamos dando");
		Regla r15=new Regla(15,2,1,0,"que realizar","Trabajando un poco…");
		Regla r16=new Regla(16,2,1,0,"que realizar","Acá ando…haciendo el TP de IA, vos?");
		Regla r17=new Regla(17,2,1,0,"donde estar","En mi casa…por?");
		Regla r18=new Regla(18,2,1,0,"donde estar","En el laboratorio de la facu…");
		Regla r19=new Regla(19,2,1,0,"donde estar","En el trabajo, intantando hacer unas pruebas a un SW");
		Regla r20=new Regla(20,3,1,0,"como llamar libro","El libro del que tenemos que estudiar se llama 'Inteligencia Artificial. Un enfoque moderno'. Es de Russel & Norvig.");
		Regla r21=new Regla(21,3,1,0,"como llamar libro","Hay 4 libros: ‘Inteligencia Artificial. Un enfoque moderno’ de Russel - Norvig; ‘Inteligencia artificial’ de Rich-Knight; ‘Inteligencia artificial. Una nueva síntesis’ de Nilsson;  y ‘MultiAgent Systems’ de Wooldridge.");
		Regla r107=new Regla(107,3,1,0,"cual ser libro","El libro del que tenemos que estudiar se llama 'Inteligencia Artificial. Un enfoque moderno'. Es de Russel & Norvig.");
		Regla r108=new Regla(108,3,1,0,"cual ser libro","Hay 4 libros: ‘Inteligencia Artificial. Un enfoque moderno’ de Russel - Norvig; ‘Inteligencia artificial’ de Rich-Knight; ‘Inteligencia artificial. Una nueva síntesis’ de Nilsson;  y ‘MultiAgent Systems’ de Wooldridge.");
		Regla r109=new Regla(109,3,1,0,"cual ser bibliografia","El libro del que tenemos que estudiar se llama 'Inteligencia Artificial. Un enfoque moderno'. Es de Russel & Norvig.");
		Regla r110=new Regla(110,3,1,0,"cual ser bibliografia","Hay 4 libros: ‘Inteligencia Artificial. Un enfoque moderno’ de Russel - Norvig; ‘Inteligencia artificial’ de Rich-Knight; ‘Inteligencia artificial. Una nueva síntesis’ de Nilsson;  y ‘MultiAgent Systems’ de Wooldridge.");				
		Regla r22=new Regla(22,3,1,0,"como organizar materia","La materia tiene varias cosas: un TP de tres entregas parciales, una clase pública en grupo, y un parcial.");
		Regla r23=new Regla(23,3,1,0,"como organizar materia","Tenemos que hacer un TP, una clase pública, y 1 parcial…");		
		Regla r24=new Regla(24,4,3,0,"como llamar profesor teoria","Milagros Gutierrez");
		Regla r25=new Regla(25,4,1,0,"como llamar profesor teoria","Creo que Milagros");
		Regla r111=new Regla(111,4,3,0,"como llamar profesora teoria","Milagros Gutierrez");
		Regla r112=new Regla(112,4,1,0,"como llamar profesora teoria","Creo que Milagros");
		Regla r26=new Regla(26,4,0,0,"como llamar profesor practica","Jorge Roa");
		Regla r27=new Regla(27,4,0,0,"como llamar profesor practica","Creo que Jorge");		
		Regla r113=new Regla(113,3,0,0,"como llamar ayudante","Jorge Roa");
		Regla r114=new Regla(114,3,0,0,"como llamar ayudante","Creo que Jorge");		
		Regla r115=new Regla(115,4,0,0,"como llamar profesora practica","No hay profesora de practica!");
		Regla r116=new Regla(116,4,3,0,"como llamar profesora practica","No hay profesora de práctica, es un profesor!");		
		Regla r28=new Regla(28,4,1,0,"como llamar agente tp","Chat Bot");
		Regla r29=new Regla(29,4,0,0,"como llamar agente tp","La verdad que no me acuerdo; jajaja!");		
		Regla r117=new Regla(117,5,1,0,"cual ser llamar agente tp","Chat Bot");
		Regla r118=new Regla(118,5,0,0,"cual ser llamar agente tp","La verdad que no me acuerdo; jajaja!");
		Regla r119=new Regla(119,4,1,0,"cual ser llamar tp","Chat Bot");
		Regla r120=new Regla(120,4,1,0,"cual ser llamar tp","La verdad que no me acuerdo; jajaja!");
		Regla r30=new Regla(30,3,0,0,"como llamar materia","Inteligencia Artificial");
		Regla r31=new Regla(31,3,0,0,"como llamar materia","IA  = inteligencia artificial :)");
		Regla r121=new Regla(121,4,0,0,"como ser llamar materia","Inteligencia Artificial");
		Regla r122=new Regla(122,4,0,0,"como ser llamar materia","IA  = inteligencia artificial :)");
		Regla r123=new Regla(123,4,0,0,"cual ser llamar materia","Inteligencia Artificial");
		Regla r124=new Regla(124,4,0,0,"cual ser llamar materia","IA  = inteligencia artificial :)");
		Regla r32=new Regla(32,3,0,0,"como llamar profesor","Milagros Gutiérrez y Jorge Roa");
		Regla r33=new Regla(33,3,0,0,"como llamar profesor","Milagros y Jorge");
		Regla r34=new Regla(34,3,0,0,"como llamar framework","Eclipse, SWI-Prolog, Mix Tex, FAIA e IDEM-IA");
		Regla r35=new Regla(35,3,0,0,"como llamar framework","En IA usamos Java, Eclipse, SWI-Prolog, Mix Tex, FAIA e IDEMIA");
		Regla r125=new Regla(125,3,0,0,"cual ser framework","Eclipse, SWI-Prolog, Mix Tex, FAIA e IDEM-IA");
		Regla r126=new Regla(126,3,0,0,"cual ser framework","En IA usamos Java, Eclipse, SWI-Prolog, Mix Tex, FAIA e IDEMIA");
		Regla r36=new Regla(36,3,0,0,"como informar grupo","Mandando un mail con la formación del mismo indicando nombre y apellido + dirección de e-mail de todos los integrantes");
		Regla r37=new Regla(37,3,0,0,"como informar grupo","Mandando un mail a la cátedra! Pone los nombres y apellidos, y los mails...");
		Regla r38=new Regla(38,3,0,0,"como conformar grupo","Los grupos tienen que ser de hasta 3 integrantes…");
		Regla r39=new Regla(39,3,0,0,"como conformar grupo","De 2 o de a 3! No se puede trabajar solo…si no tenes grupo podemos trabajar juntos :)");
		Regla r40=new Regla(40,3,0,0,"como evaluar tp","Se evalúa: 1) El informe técnico. 2) Que se alcance el objetivo del TP. 3) La presentación de la solución de software. 4) La cantidad y calidad de las pruebas que se realicen. 5) La expresividad en el coloquio. Son muchas cosas…pero al menos eso es lo que dijeron los profesores");
		Regla r41=new Regla(41,3,0,0,"como evaluar tp","Se evalúa con el informe, viendo si alcanza los objetivos, según la solución de software que presentemos, la cantidad y calidad de las pruebas, y la expresividad en el coloquio.");
		Regla r127=new Regla(127,5,0,0,"cual ser que evaluar tp","Se evalúa: 1) El informe técnico. 2) Que se alcance el objetivo del TP. 3) La presentación de la solución de software. 4) La cantidad y calidad de las pruebas que se realicen. 5) La expresividad en el coloquio. Son muchas cosas…pero al menos eso es lo que dijeron los profesores");
		Regla r128=new Regla(128,5,0,0,"cual ser que evaluar tp","Se evalúa con el informe, viendo si alcanza los objetivos, según la solución de software que presentemos, la cantidad y calidad de las pruebas, y la expresividad en el coloquio.");
		Regla r42=new Regla(42,3,0,0,"como entregar tp","El TP tiene 2 etapas, y en cada una se entregan distintas cosas (vocabulario, sistemas de producción, conjunto de reglas, etc). Todas las entregas son por el sitio…fíjate sino lo que dice el enunciado…");
		Regla r43=new Regla(43,3,0,0,"como entregar tp","Por el sitio de IA en el campus virtual!");
		Regla r44=new Regla(44,5,0,0,"cual ser fecha entregar tp","La 1° etapa tiene 2 entregas: una el 23/03 y otra el 14/05. La 2° etapa tiene como fecha límite el 25/06/2012.");
		Regla r45=new Regla(45,5,0,0,"cual ser fecha entregar tp","La 1° etapa tiene 2 entregas: una el 23/03 (vocabulario) y otra el 14/05 (conjunto de reglas + búsqueda). La 2° etapa tiene como fecha límite el 25/06/2012 para entregar el sistema de producción.");	
		Regla r129=new Regla(129,3,0,0,"cuando entregar tp","La 1° etapa tiene 2 entregas: una el 23/03 y otra el 14/05. La 2° etapa tiene como fecha límite el 25/06/2012.");
		Regla r130=new Regla(130,3,0,0,"cuando entregar tp","La 1° etapa tiene 2 entregas: una el 23/03 (vocabulario) y otra el 14/05 (conjunto de reglas + búsqueda). La 2° etapa tiene como fecha límite el 25/06/2012 para entregar el sistema de producción.");		
		Regla r46=new Regla(46,3,0,0,"como ser mail","ia@frsf.utn.edu.ar");
		Regla r47=new Regla(47,3,3,0,"como ser mail","No me acuerdo bien…creo que es ia@frsf.utn.edu.ar, pero no estoy muy seguro!");				
		Regla r131=new Regla(131,3,0,0,"cual ser mail","ia@frsf.utn.edu.ar");
		Regla r132=new Regla(132,3,3,0,"cual ser mail","No me acuerdo bien…creo que es ia@frsf.utn.edu.ar, pero no estoy muy seguro!");				
		Regla r48=new Regla(48,3,0,0,"como regularizar materia","1)Hay que aprobar: a) 2 Trabajos Prácticos con un puntaje igual o superior al 60% b) aprobar un parcial o su recuperatorio con un puntaje igual o superior al 60% c) Presentar una clase pública 2)Tener el 80% de la asistencia");
		Regla r49=new Regla(49,3,0,0,"como regularizar materia","Aprobando los 2 TP y el parcial con 60%, la clase pública y con la asistencia (aunque nunca toman).");				
		Regla r50=new Regla(50,3,0,0,"como aprobar materia","Hay que aprobar el trabajo práctico, el parcial y un examen final.");
		Regla r51=new Regla(51,3,0,0,"como aprobar materia","Una vez que regularizaste o promocionaste, rendís el final y listo!");				
		Regla r52=new Regla(52,3,0,0,"como realizar actividad","En grupo de hasta 3 alumnos");
		Regla r53=new Regla(53,3,0,0,"como realizar actividad","De forma grupal (menos los parciales obviamente!)");		
		Regla r54=new Regla(54,3,0,0,"como calcular nota","La nota final se calcula como un promedio entre el examen final teórico-práctico y el examen teórico (en caso de rendir regular) o un promedio de las notas del TP, parcial y examen teórico (en caso de rendir promocionado)");
		Regla r55=new Regla(55,3,0,0,"como calcular nota","Como un promedio de lo que te sacaste en los parciales calculo…no se si lo dijeron en clases.");				
		Regla r56=new Regla(56,3,0,0,"cual ser sitio","http://campusvirtual.frsf.utn.edu.ar/");
		Regla r57=new Regla(57,3,0,0,"cual ser sitio","No se bien…entra al campus de la facu y fíjate ahí!");				
		Regla r58=new Regla(58,3,2,0,"cuando ser parcial","El 1º de junio");
		Regla r59=new Regla(59,3,3,0,"cuando ser parcial","El 1/6/2012");	
		Regla r133=new Regla(133,4,2,0,"cual ser fecha parcial","El 1º de junio");
		Regla r134=new Regla(134,4,3,0,"cual ser fecha parcial","El 1/6/2012");
		Regla r60=new Regla(60,2,0,0,"cuantas actividad","5 creo, entre TP, parcial y coloquios.");
		Regla r61=new Regla(61,2,3,0,"cuantas actividad","5 según la transparencia de la primera clase.");
		Regla r62=new Regla(62,3,0,0,"cuantas entregar tp","Tiene 3 entregas, 2 para la primera parte y 1 para la segunda.");
		Regla r63=new Regla(63,3,0,0,"cuantas entregar tp","Creo que son 3 (2 para la parte 2 y 1 para la 2).");
		Regla r64=new Regla(64,5,0,0,"cual ser nota promocionar tp","80%");		
		Regla r65=new Regla(65,5,0,0,"cual ser nota promocionar tp","Tenes que sacar un 8!");
		Regla r135=new Regla(135,5,0,0,"cual ser nota promocionar parcial","80%");		
		Regla r136=new Regla(136,5,0,0,"cual ser nota promocionar parcial","Tenes que sacar un 8!");
		Regla r137=new Regla(64,4,0,0,"cual ser porcentaje asistencia","80%");		
		Regla r66=new Regla(66,5,0,0,"cual ser nota regularizar tp","60%");
		Regla r67=new Regla(67,5,0,0,"cual ser nota regularizar tp","Tenes que sacar un 6!");
		Regla r138=new Regla(138,5,0,0,"cual ser nota regularizar parcial","60%");
		Regla r139=new Regla(139,5,0,0,"cual ser nota regularizar parcial","Tenes que sacar un 6!");
		Regla r68=new Regla(68,5,0,0,"cual ser tema que charla","Los temas son: 1. Búsqueda: Métodos de agrupamiento no supervisado para la integración de datos genómicos y metabólicos de múltiples líneas de introgresión. 2. Cálculo situacional: A survey on application of Situation calculus in business information systems. 3. Robotica: Navigation of mobile robots in the presence of obstacles. 4. Robotica: Robot soccer with LEGO Mindstorms. 5. Robotica + planificación: Supporting 3D route planning in indoor space based on the LEGO representation. 6. Planificación: Artificial Intelligence and Grids: Workflow Planning and Beyond. 7. Sistemas expertos: Hot-news: Al final una supercomputadora aplastó a la inteligencia humana. 8. Ontologías: The semantic-web a new form of web content that is meaningfull to computers will unleash a revolution of new possibilities. 9. Redes neuronales: Array of Multilayer Perceptrons with No-class Resampling Training for Face Recognition.");
		Regla r69=new Regla(69,5,0,0,"cual ser tema que charla","No se, creo que en la primera transparencia están todos...");
		Regla r140=new Regla(140,4,0,0,"cual ser tema charla","Los temas son: 1. Búsqueda: Métodos de agrupamiento no supervisado para la integración de datos genómicos y metabólicos de múltiples líneas de introgresión. 2. Cálculo situacional: A survey on application of Situation calculus in business information systems. 3. Robotica: Navigation of mobile robots in the presence of obstacles. 4. Robotica: Robot soccer with LEGO Mindstorms. 5. Robotica + planificación: Supporting 3D route planning in indoor space based on the LEGO representation. 6. Planificación: Artificial Intelligence and Grids: Workflow Planning and Beyond. 7. Sistemas expertos: Hot-news: Al final una supercomputadora aplastó a la inteligencia humana. 8. Ontologías: The semantic-web a new form of web content that is meaningfull to computers will unleash a revolution of new possibilities. 9. Redes neuronales: Array of Multilayer Perceptrons with No-class Resampling Training for Face Recognition.");
		Regla r141=new Regla(141,4,0,0,"cual ser tema charla","No se, creo que en la primera transparencia están todos...");
		Regla r70=new Regla(70,4,3,0,"cual ser porcentaje asistencia","80%...pero te cuento un secretito: nunca toman asistencia :)");
		Regla r71=new Regla(71,3,0,0,"cual ser modalidad","Es regular y promoción parcial.");
		Regla r72=new Regla(72,3,0,0,"cual ser modalidad","Podes quedar regular o con una promoción parcial (después tenes que rendir la teoría).");
		Regla r73=new Regla(73,4,0,0,"cual ser fecha recuperatorio","El 08/06/12.");
		Regla r74=new Regla(74,4,0,0,"cual ser fecha recuperatorio","El 8 de junio.");
		Regla r75=new Regla(75,3,0,0,"cuando ser recuperatorio","El 08/06/12.");
		Regla r76=new Regla(76,3,0,0,"cuando ser recuperatorio","El 8 de junio.");
		Regla r77=new Regla(77,3,0,0,"cuando ser coloquio","El 1° coloquio es el lunes 14/05 y el 2° es el 25/06/2012.");
		Regla r78=new Regla(78,3,0,0,"cuando ser coloquio","Hay 2 coloquios, uno el 14/5 y otro el 25/6.");
		Regla r79=new Regla(79,4,0,0,"cuantas charla que ser","Solo 1!");
		Regla r80=new Regla(80,4,0,0,"cuantas charla que ser","Cuantas clases queres dar? Jajaja! Solo te piden 1!");
		Regla r142=new Regla(142,3,1,0,"cuantas charla ser","Solo 1!");
		Regla r143=new Regla(143,3,0,0,"cuantas charla ser","Cuantas clases queres dar? Jajaja! Solo te piden 1!");
		Regla r144=new Regla(144,3,1,0,"cuantas charla realizar","Solo 1!");
		Regla r145=new Regla(145,3,0,0,"cuantas charla realizar","Cuantas clases queres dar? Jajaja! Solo te piden 1!");
		Regla r81=new Regla(81,3,0,0,"como promocionar materia","1)Hay que aprobar: a) 2 Trabajos Prácticos con un puntaje igual o superior al 80% b) aprobar un parcial o su recuperatorio con un puntaje igual o superior al 80% c) Presentar una clase pública 2)Tener el 80% de la asistencia");
		Regla r82=new Regla(82,3,0,0,"como promocionar materia","Aprobando los 2 TP y el parcial con 80%, la clase pública y con la asistencia (aunque nunca toman).");
		Regla r83=new Regla(83,4,0,0,"cual ser horario teoria","Los viernes de 19:45 a 22 hs.");
		Regla r84=new Regla(84,4,0,0,"cual ser horario teoria","Solo damos teoría los viernes de 19:45 a 22 hs.");
		Regla r146=new Regla(146,3,0,0,"cuando ser teoria","Los viernes de 19:45 a 22 hs.");
		Regla r147=new Regla(147,3,0,0,"cuando ser teoria","Solo damos teoría los viernes de 19:45 a 22 hs.");
		Regla r85=new Regla(85,4,0,0,"cual ser horario practica","Los lunes de 19 a 21:15 hs");
		Regla r86=new Regla(86,4,0,0,"cual ser horario practica","Solo damos práctica los lunes de 19 a 21:15 hs");
		Regla r148=new Regla(148,3,0,0,"cuando ser practica","Los lunes de 19 a 21:15 hs");
		Regla r149=new Regla(149,3,0,0,"cuando ser practica","Solo damos práctica los lunes de 19 a 21:15 hs");	
		Regla r87=new Regla(87,4,0,0,"cual ser horario consulta","Los miércoles de 16 a 18 hs.");
		Regla r88=new Regla(88,4,0,0,"cual ser horario consulta","Los miércoles de 16 a 18 hs. (salvo en semana de examen)");
		Regla r150=new Regla(150,3,0,0,"cuando ser consulta","Los miércoles de 16 a 18 hs.");
		Regla r151=new Regla(151,3,0,0,"cuando ser consulta","Los miércoles de 16 a 18 hs. (salvo en semana de examen)");			
		Regla r89=new Regla(89,1,3,0,"chau","Chauuuuu!!!");
		Regla r90=new Regla(90,1,2,0,"chau","Chau chau!!!");	
		Regla r152=new Regla(152,2,3,0,"que hola","Chauuuuu!!!");
		Regla r153=new Regla(153,2,2,0,"que hola","Chau chau!!!");			
		Regla r91=new Regla(91,1,2,0,"gracias","De nada!");
		Regla r92=new Regla(92,1,0,0,"gracias","No hay drama :)!");	
		
		//Se agregan las reglas de los nodos particulares.	
		hola.addRegla(r3);
		hola.addRegla(r4);
		hola.addRegla(r152);
		hola.addRegla(r153);
		llamar.addRegla(r5);
		llamar.addRegla(r6);		
		ser.addRegla(r97);
		ser.addRegla(r8);				
		llamar.addRegla(r98);				
		llamar.addRegla(r7);		
		estar.addRegla(r9);
		estar.addRegla(r10);
		estar.addRegla(r11);
		estar.addRegla(r12);				
		estar.addRegla(r99);
		estar.addRegla(r100);
		estar.addRegla(r101);
		estar.addRegla(r102);				
		ir.addRegla(r103);
		ir.addRegla(r104);
		ir.addRegla(r105);
		ir.addRegla(r106);				
		realizar.addRegla(r13);
		realizar.addRegla(r14);
		realizar.addRegla(r15);
		realizar.addRegla(r16);
		estar.addRegla(r17);
		estar.addRegla(r18);
		estar.addRegla(r19);		
		libro.addRegla(r20);
		libro.addRegla(r21);		
		libro.addRegla(r107);
		libro.addRegla(r108);
		bibliografia.addRegla(r109);
		bibliografia.addRegla(r110);				
		materia.addRegla(r22);
		materia.addRegla(r23);		
		teoria.addRegla(r24);
		teoria.addRegla(r25);		
		teoria.addRegla(r111);
		teoria.addRegla(r112);		
		practica.addRegla(r26);
		practica.addRegla(r27);		
		ayudante.addRegla(r113);
		ayudante.addRegla(r114);				
		practica.addRegla(r115);
		practica.addRegla(r116);				
		tp.addRegla(r28);
		tp.addRegla(r29);				
		tp.addRegla(r117);
		tp.addRegla(r118);		
		tp.addRegla(r119);
		tp.addRegla(r120);		
		materia.addRegla(r30);
		materia.addRegla(r31);		
		materia.addRegla(r121);
		materia.addRegla(r122);
		materia.addRegla(r123);
		materia.addRegla(r124);				
		profesor.addRegla(r32);
		profesor.addRegla(r33);		
		framework.addRegla(r34);
		framework.addRegla(r35);		
		framework.addRegla(r125);
		framework.addRegla(r126);		
		grupo.addRegla(r36);
		grupo.addRegla(r37);		
		grupo.addRegla(r38);
		grupo.addRegla(r39);		
		tp.addRegla(r40);
		tp.addRegla(r41);		
		tp.addRegla(r127);
		tp.addRegla(r128);
		tp.addRegla(r42);
		tp.addRegla(r43);		
		tp.addRegla(r44);
		tp.addRegla(r45);				
		tp.addRegla(r129);
		tp.addRegla(r130);		
		mail.addRegla(r46);
		mail.addRegla(r47);
		mail.addRegla(r131);
		mail.addRegla(r132);				
		materia.addRegla(r48);
		materia.addRegla(r49);				
		materia.addRegla(r50);
		materia.addRegla(r51);				
		actividad.addRegla(r52);
		actividad.addRegla(r53);		
		nota.addRegla(r54);
		nota.addRegla(r55);				
		sitio.addRegla(r56);
		sitio.addRegla(r57);				
		parcial.addRegla(r58);
		parcial.addRegla(r59);		
		parcial.addRegla(r133);
		parcial.addRegla(r134);				
		actividad.addRegla(r60);
		actividad.addRegla(r61);				
		tp.addRegla(r62);
		tp.addRegla(r63);
		tp.addRegla(r64);		
		tp.addRegla(r65);
		parcial.addRegla(r135);		
		parcial.addRegla(r136);
		asistencia.addRegla(r137);						
		tp.addRegla(r66);
		tp.addRegla(r67);
		parcial.addRegla(r138);
		parcial.addRegla(r139);
		charla.addRegla(r68);
		charla.addRegla(r69);
		charla.addRegla(r140);
		charla.addRegla(r141);			
		asistencia.addRegla(r70);
		recuperatorio.addRegla(r73);
		recuperatorio.addRegla(r74);		
		recuperatorio.addRegla(r75);
		recuperatorio.addRegla(r76);	
		modalidad.addRegla(r71);
		modalidad.addRegla(r72);		
		coloquio.addRegla(r77);
		coloquio.addRegla(r78);				
		ser.addRegla(r79);		
		ser.addRegla(r80);		
		ser.addRegla(r142);
		ser.addRegla(r143);
		realizar.addRegla(r144);
		realizar.addRegla(r145);		
		materia.addRegla(r81);
		materia.addRegla(r82);				
		teoria.addRegla(r83);
		teoria.addRegla(r84);		
		teoria.addRegla(r146);
		teoria.addRegla(r147);		
		practica.addRegla(r85);
		practica.addRegla(r86);
		practica.addRegla(r148);
		practica.addRegla(r149);	
		consulta.addRegla(r87);
		consulta.addRegla(r88);
		consulta.addRegla(r150);
		consulta.addRegla(r151);				
		chau.addRegla(r89);
		chau.addRegla(r90);					
		gracias.addRegla(r91);
		gracias.addRegla(r92);
		donde.addRegla(r1);
		donde.addRegla(r2);
		que.addRegla(r1);
		que.addRegla(r2);
		cuantas.addRegla(r1);
		cuantas.addRegla(r2);
		cual.addRegla(r1);
		cual.addRegla(r2);
		cuando.addRegla(r1);
		cuando.addRegla(r2);
		quien.addRegla(r1);
		quien.addRegla(r2);
		como.addRegla(r1);
		como.addRegla(r2);	
		
		//Se devuelve la lista generada.
		return lista; 
		
	}

	/**
	 * Metodo que carga los arcos del grafo.
	 * @return La lista de arcos.
	 */
	public static LinkedList<Arco> cargarArcos(){
		
		LinkedList<Arco> lista= new LinkedList<Arco>();
		lista.add(new Arco("hola","donde"));
		lista.add(new Arco("hola","que"));
		lista.add(new Arco("hola","como"));
		lista.add(new Arco("hola","cuantas"));
		lista.add(new Arco("hola","cuando"));
		lista.add(new Arco("hola","cual"));
		lista.add(new Arco("hola","quien"));
		lista.add(new Arco("donde","estar"));
		lista.add(new Arco("que","hola"));
		lista.add(new Arco("que","ir"));
		lista.add(new Arco("que","estar"));
		lista.add(new Arco("cuantas","actividad"));
		lista.add(new Arco("cuantas","entregar"));
		lista.add(new Arco("cuantas","charla"));
		lista.add(new Arco("cual","ser"));
		lista.add(new Arco("ser","tema"));
		lista.add(new Arco("tema","charla"));
		lista.add(new Arco("ser","charla"));
		lista.add(new Arco("ser","coloquio"));
		lista.add(new Arco("ser","mail"));
		lista.add(new Arco("ser","sitio"));
		lista.add(new Arco("ser","apunte"));
		lista.add(new Arco("cuando","ser"));
		lista.add(new Arco("cuando","entregar"));
		lista.add(new Arco("ser","entregar"));
		lista.add(new Arco("quien","ser"));
		lista.add(new Arco("ser","final"));
		lista.add(new Arco("ser","nota"));
		lista.add(new Arco("como","entregar"));
		lista.add(new Arco("como","ir"));
		lista.add(new Arco("como","estar"));
		lista.add(new Arco("como","ser"));
		lista.add(new Arco("entregar","tp"));
		lista.add(new Arco("como","evaluar"));
		lista.add(new Arco("ser","evaluar"));
		lista.add(new Arco("evaluar","tp"));
		lista.add(new Arco("ser","tp"));
		lista.add(new Arco("ser","objetivo"));
		lista.add(new Arco("como","llamar"));
		lista.add(new Arco("como","realizar"));
		lista.add(new Arco("realizar","final"));
		lista.add(new Arco("realizar","actividad"));
		lista.add(new Arco("entregar","realizar"));
		lista.add(new Arco("ser","fecha"));
		lista.add(new Arco("ser","llamar"));
		lista.add(new Arco("ser","framework"));
		lista.add(new Arco("llamar","framework"));
		lista.add(new Arco("ser","recuperatorio"));
		lista.add(new Arco("ser","parcial"));
		lista.add(new Arco("ser","libro"));
		lista.add(new Arco("ser","consulta"));
		lista.add(new Arco("ser","profesora"));
		lista.add(new Arco("ser","profesor"));
		lista.add(new Arco("ser","clase"));
		lista.add(new Arco("ser","horario"));
		lista.add(new Arco("ser","bibliografia"));
		lista.add(new Arco("ser","porcentaje"));
		lista.add(new Arco("ser","modalidad"));
		lista.add(new Arco("porcentaje","asistencia"));
		lista.add(new Arco("llamar","libro"));
		lista.add(new Arco("llamar","ayudante"));
		lista.add(new Arco("llamar","profesora"));
		lista.add(new Arco("llamar","profesor"));
		lista.add(new Arco("llamar","tp"));
		lista.add(new Arco("llamar","agente"));
		lista.add(new Arco("llamar","materia"));
		lista.add(new Arco("fecha","recuperatorio"));
		lista.add(new Arco("fecha","tp"));
		lista.add(new Arco("fecha","parcial"));
		lista.add(new Arco("agente","tp"));
		lista.add(new Arco("aprobar","parcial"));
		lista.add(new Arco("como","aprobar"));
		lista.add(new Arco("aprobar","tp"));
		lista.add(new Arco("promocionar","parcial"));
		lista.add(new Arco("promocionar","tp"));
		lista.add(new Arco("como","promocionar"));
		lista.add(new Arco("final","promocionar"));
		lista.add(new Arco("promocionar","materia"));
		lista.add(new Arco("aprobar","materia"));
		lista.add(new Arco("objetivo","materia"));
		lista.add(new Arco("como","calcular"));
		lista.add(new Arco("calcular","nota"));
		lista.add(new Arco("nota","promocionar"));
		lista.add(new Arco("nota","regularizar"));
		lista.add(new Arco("regularizar","tp"));
		lista.add(new Arco("como","regularizar"));
		lista.add(new Arco("como","organizar"));
		lista.add(new Arco("final","regularizar"));
		lista.add(new Arco("como","informar"));
		lista.add(new Arco("informar","grupo"));
		lista.add(new Arco("como","conformar"));
		lista.add(new Arco("conformar","grupo"));
		lista.add(new Arco("regularizar","materia"));
		lista.add(new Arco("organizar","materia"));
		lista.add(new Arco("realizar","parcial"));
		lista.add(new Arco("profesora","teoria"));
		lista.add(new Arco("profesora","practica"));
		lista.add(new Arco("profesor","teoria"));
		lista.add(new Arco("profesor","practica"));
		lista.add(new Arco("clase","teoria"));
		lista.add(new Arco("clase","practica"));
		lista.add(new Arco("horario","practica"));
		lista.add(new Arco("horario","teoria"));
		lista.add(new Arco("horario","consulta"));
		lista.add(new Arco("chau","gracias"));
		lista.add(new Arco("chau","que"));
		lista.add(new Arco("entregar","realizar"));
		lista.add(new Arco("que","realizar"));
		lista.add(new Arco("ser","que"));
		lista.add(new Arco("que","evaluar"));
		lista.add(new Arco("fecha","entregar"));
		lista.add(new Arco("regularizar","parcial"));
		lista.add(new Arco("tema","que"));
		lista.add(new Arco("que","charla"));
		lista.add(new Arco("que","ser"));
		lista.add(new Arco("charla","realizar"));
		lista.add(new Arco("charla","ser"));
		lista.add(new Arco("charla","que"));
		lista.add(new Arco("ser","teoria"));
		lista.add(new Arco("ser","practica"));
		lista.add(new Arco("clase","consulta"));
		return lista;
		
	}
	
	/**
	 * Metodo que devuelve la lista de nodos adyacentes a un 
	 * nodo dado.
	 * @param aString
	 * @return La lista de nodos adyacentes.
	 */
	private static LinkedList<NodoG> adyacentes(String aString){
		LinkedList<NodoG> nodoList=new LinkedList<NodoG>();
		LinkedList<String> auxList=new LinkedList<String>();
		Arco aux;
		Iterator<Arco> it = listaArcos.iterator();
		while(it.hasNext())
		{
			aux=(Arco)it.next();
			if(aux.getInicio().equals(aString)) auxList.add(aux.getFin());
		}
		NodoG aux2;
		Iterator<NodoG> it2= listaNodos.iterator();
		while(it2.hasNext())
		{
			aux2=it2.next();
			if(auxList.contains(aux2.getEtiqueta())) nodoList.add(aux2);
		}
		return nodoList;
		
	}
	
	/**
	 * Metodo que determina si el primer string es sucesor del 
	 * segundo.
	 * @param aString1
	 * @param aString2
	 * @return True si existe un arco, False en otro caso.
	 */
	public static boolean esSucesor(String aString1, String aString2)
	{
		if(aString2.compareTo("")==0) return false;
		LinkedList<NodoG> listaAdyacentes = adyacentes(aString2);
		NodoG aux;
		Iterator<NodoG> it=listaAdyacentes.iterator();
		while(it.hasNext())
		{
			aux=(NodoG) it.next();
			if(aux.getEtiqueta().equals(aString1))
				return true;
		}
		return false;
	}

	/**
	 * Metodo que obtiene el conjunto de reglas a partir de un nodo
	 * dado.
	 * @param aNodo
	 * @return El conjunto de reglas.
	 */
	public static LinkedList<Regla> obtenerReglas(String aNodo)
	{
		LinkedList<Regla> listaReglas = new LinkedList<Regla>();		
		Iterator<NodoG> it=listaNodos.iterator();
		while(it.hasNext())
		{
			NodoG aux = it.next();
			if(aux.getEtiqueta().equals(aNodo))
			{
				listaReglas = aux.getReglas();
				return listaReglas;
			}				
		}
		return null;
	}
	
}
