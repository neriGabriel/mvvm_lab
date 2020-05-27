package com.example.mvvmlab.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mvvmlab.R;
import com.example.mvvmlab.databinding.ActivityMainBinding;
import com.example.mvvmlab.viewmodel.MyViewModel;

//Com o mvvm a unica responsabilidade da view é cuidar do fluxo da view...
//Preza-se que cada view/fragment tenha um viewmodel, porém pode ser que tenha mais
//O estado da informação muda na viewmodel
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        //Dizendo ao meu textView que quando o valor for alterado seu valor é alterado
        //Iniciando minha variavel de viewmodel
        this.myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        //Fazendo a 'assinatura' no padrão observe
        //alterando os valores com lambda
        this.myViewModel.getName().observe(this, s -> binding.textName.setText(s));

        this.binding.button.setOnClickListener(view -> {
            myViewModel.getName().setValue("Gabriel");
        });
    }
}
