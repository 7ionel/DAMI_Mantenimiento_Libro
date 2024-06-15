package com.example.semana07.adapter; // Paquete de la aplicación

import android.content.Context; // Importa la clase Context para manejar el contexto de la aplicación
import android.view.LayoutInflater; // Importa la clase LayoutInflater para inflar layouts
import android.view.View; // Importa la clase View para manejar elementos de la UI
import android.view.ViewGroup; // Importa la clase ViewGroup para manejar grupos de vistas
import android.widget.ArrayAdapter; // Importa la clase ArrayAdapter para adaptar arrays a ListViews
import android.widget.TextView; // Importa la clase TextView para manejar textos

import androidx.annotation.NonNull; // Importa la anotación NonNull para indicar que los parámetros no pueden ser nulos
import androidx.annotation.Nullable; // Importa la anotación Nullable para indicar que los parámetros pueden ser nulos

import com.example.semana07.R; // Importa el archivo de recursos R para acceder a los recursos del proyecto
import com.example.semana07.entity.Libro; // Importa la clase Libro para manejar libros

import java.util.List; // Importa List para manejar listas

// Clase LibroAdapter que extiende ArrayAdapter<Libro>
public class LibroAdapter extends ArrayAdapter<Libro> {

    private Context context; // Contexto de la aplicación
    private List<Libro> lista; // Lista de libros

    // Constructor del adaptador
    public LibroAdapter(@NonNull Context context, int resource, @NonNull List<Libro> lista) {
        super(context, resource, lista); // Llama al constructor de la superclase
        this.context = context; // Asigna el contexto
        this.lista = lista; // Asigna la lista de libros
    }

    // Método getView, se llama para obtener la vista de cada ítem en la lista
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Inflador de layouts para crear vistas
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        // Infla el layout de cada ítem
        View row = inflater.inflate(R.layout.activity_libro_item_crud, parent, false);

        // Obtiene el libro en la posición actual
        Libro obj = lista.get(position);

        // Configura el TextView para el ID del libro
        TextView txtId = row.findViewById(R.id.itemIdLibro);
        txtId.setText("ID: " + String.valueOf(obj.getIdLibro())); // Establece el texto del ID del libro

        // Configura el TextView para el título del libro
        TextView txtTitulo = row.findViewById(R.id.itemTituloLibro);
        txtTitulo.setText("Título: " + obj.getTitulo()); // Establece el texto del título del libro

        // Configura el TextView para el año del libro
        TextView txtAnio = row.findViewById(R.id.itemAnioLibro);
        txtAnio.setText("Año: " + obj.getAnio()); // Establece el texto del año del libro

        // Configura el TextView para la serie del libro
        TextView txtSerie = row.findViewById(R.id.itemSerieLibro);
        txtSerie.setText("Serie: " + obj.getSerie()); // Establece el texto de la serie del libro

        // Configura el TextView para la categoría del libro
        TextView txtCategoria = row.findViewById(R.id.itemCategoriaLibro);
        txtCategoria.setText("Categoría: " + obj.getCategoria().getDescripcion()); // Establece el texto de la categoría del libro

        // Configura el TextView para el país del libro
        TextView txtPais = row.findViewById(R.id.itemPaisLibro);
        txtPais.setText("País: " + obj.getPais().getNombre()); // Establece el texto del país del libro

        return row; // Retorna la vista inflada y configurada para el ítem actual
    }
}
