package br.com.cna;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Date dtNascimento;

	public Employee(int id, String name, Date dtNascimento) {
		this.id = id;
		this.name = name;
		this.dtNascimento = dtNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	// Exemplo:
	public static void main(String[] args) {
		List<Employee> records = new ArrayList<>();
		for (int i = 0; i < 5000; i++) {
			records.add(new Employee(i, "Employee " + i, new Date()));
		}

		// implementação modelo 1 -> serialize / desserialize 1
		long tempoProcessamento1 = serialize1(records);

		// implementação modelo 2 -> serialize / desserialize 2
		long tempoProcessamento2 = 0;// serialize2(records);

		System.out.println("Tempo de processamento 1= " + tempoProcessamento1);
		System.out.println("Tempo de processamento 2= " + tempoProcessamento2);
	}
	// ...

	private static long serialize1(List<Employee> records) {
		long tempoInicial = System.currentTimeMillis(), tempoFinal = 0, tempoMetodo=0;
		// execução do método
		try {
			FileOutputStream fileStream = new FileOutputStream("serialize1.ser");
			
			//serializando
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			for (int i = 0; i < records.size(); i++) 
				os.writeObject(records.get(i)); // Serializa os objetos e grava no arquivo serialize1.ser

			// desserializando
			FileInputStream fileInputStream = new FileInputStream("serialize1.ser");
			ObjectInputStream is = new ObjectInputStream(fileInputStream);
			for (int i = 0; i < records.size(); i++) 
				is.readObject();

			os.close();
			is.close();
			
			tempoFinal = System.currentTimeMillis();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		tempoMetodo = tempoFinal - tempoInicial;
		return tempoMetodo;
	}
}
