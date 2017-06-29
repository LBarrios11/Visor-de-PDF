package Clases;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.*;

import com.sun.pdfview.*;

public class Principal extends JFrame {
	
private	PagePanel panelpdf;
	// panel principal
private	JFileChooser selector;
	// selector 
private	PDFFile pdffile;
	//
private	int indice=0;
	// indice , cantidad de paginas
	
public Principal(){
		panelpdf=new PagePanel();
		JMenuBar barra=new JMenuBar();
		JMenu archivo=new JMenu("Archivo");
		JMenuItem ver=new JMenuItem("Buscar Archivo");
		ver.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent e) {
				indice=0;
				selector=new JFileChooser();
				int op=selector.showOpenDialog(Principal.this);
				if(op==JFileChooser.APPROVE_OPTION){
					try{
						// obtengo archivo seleccionado por el usuaario
					File file = selector.getSelectedFile();
			        RandomAccessFile raf = new RandomAccessFile(file, "r");
			  
			        FileChannel channel = raf.getChannel();
			        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,0, channel.size());
			        pdffile = new PDFFile(buf);
			        PDFPage page = pdffile.getPage(indice);
			        panelpdf.showPage(page);
			        repaint();
					}catch(IOException ioe){
						JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
					}
				}
			}
			
		});
		JPanel pabajo=new JPanel();
		// instancio el panel donde estaran los botones de siguiente y anterior
		JButton bsiguiente=new JButton("Siguiente");
		// boton siguiente que permitira pasar de pagina
		bsiguiente.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				indice++;
				PDFPage page = pdffile.getPage(indice);
			    panelpdf.showPage(page);
			}
			
		});
		/// boton anterior que permitira retroceder de pagina
		JButton banterior=new JButton("Anterior");
		banterior.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				indice--;
				PDFPage page = pdffile.getPage(indice);
			    panelpdf.showPage(page);
			}
			
		});
		// 
		JButton CP=new JButton("CantPalabras");
		CP.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
	         // recorro todas las paginas y cuento la cantidad de palabras
				int cont1=0,cont2=0;
				
				
			}
			
		});
		JButton Max=new JButton("+");
		Max.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
	         // recorro todas las paginas y cuento la cantidad de palabras
				int cont1=0,cont2=0;
				
				
			}
			
		});
		JButton Min=new JButton("-");
		Min.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
	         // recorro todas las paginas y cuento la cantidad de palabras
				int cont1=0,cont2=0;
			//pikchu estuvo ac·XD 
				// esto es una caca
			}
			
		});
		// agrego los botones en el panel
		
		pabajo.add(banterior);
		pabajo.add(bsiguiente);
		pabajo.add(CP);
		pabajo.add(Max);
		pabajo.add(Min);
		archivo.add(ver);
		barra.add(archivo);
		setJMenuBar(barra);
		add(panelpdf);
		add(pabajo,BorderLayout.SOUTH);
	}
	
	public static void main(String arg[]){
		Principal p=new Principal();
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setVisible(true);
		p.setBounds(0, 0, 500, 500);
		p.setLocationRelativeTo(null);
	}

}
