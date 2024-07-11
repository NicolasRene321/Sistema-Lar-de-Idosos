let res = document.getElementById('res')
let res_gravar = document.getElementById('res_gravar')
let gravar = document.getElementById('gravar')
let deletar = document.getElementById('deletar')
let atualizar = document.getElementById('atualizar')
let buscar = document.getElementById('buscar')
// gravar-----------------------------------------------------

gravar.addEventListener('click', ()=>{
    const nomeDoador = document.getElementById('nomeDoador').value
    const cnpjDoador = document.getElementById('cnpjDoador').value
    const cpfDoador = document.getElementById('cpfDoador').value
    const enderecoDoador = document.getElementById('enderecoDoador').value
    const emailDoador = document.getElementById('emailDoador').value
    const telefoneDoador = document.getElementById('telefoneDoador').value
    const situacaoDoador = document.getElementById('situacaoDoador').value
    const codFuncionario = Number(document.getElementById('codFuncionario').value)
    
    const dados = {
        nomeDoador: nomeDoador,
        cnpjDoador: cnpjDoador,
        cpfDoador: cpfDoador,
        enderecoDoador: enderecoDoador,
        emailDoador: emailDoador,
        telefoneDoador: telefoneDoador,
        situacaoDoador: situacaoDoador,
        codFuncionario:codFuncionario
    }
    
    
    fetch('http://localhost:8080/doador', {
        method: 'POST',
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(dados)
    })
    .then(resposta => resposta.json())
    .then(dados => {
        res.innerHTML = " Doador cadastrado com sucesso! <br><br>"
        res.innerHTML += "Código do Doador: " + dados.codDoador + "<br>"
        res.innerHTML += "Nome do Doador: " + dados.nomeDoador + "<br>"
        res.innerHTML += "CNPJ do Doador: " + dados.cnpjDoador + "<br>"
        res.innerHTML += "CPF do Doador: " + dados.cpfDoador + "<br>"
        res.innerHTML += "Endereço do Doador: " +  dados.enderecoDoador + "<br>"
        res.innerHTML += "Email do Doador: " +  dados.emailDoador + "<br>"
        res.innerHTML += "Telefone do Doador: " +  dados.telefoneDoador+ "<br>" 
        res.innerHTML += "Situação Doador: " +  dados.situacaoDoador + "<br>" 
        res.innerHTML += "Id do Funcionário: " +  dados.codFuncionario
        
        
    })
    .catch((err) => console.error("Erro ao tentar cadastrar o Doador!", err))
    
    
    
    
})

//buscacr---------------------------------------------------------------------------
buscar.addEventListener('click', () => {
    let codDoador = Number(document.getElementById('codDoador').value);

    fetch(`http://localhost:8080/doador/${codDoador}`)
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML += "Código: " + dados.codDoador + "<br>" + "Nome: " + dados.nomeDoador +"<br>"+
            "CNPJ: " + dados.cnpjDoador + "<br>" +  "CPF: " + dados.cpfDoador  +
            "<br>" + "endereço: " +dados.enderecoDoador + "<br>" + "email: " + dados.emailDoador + "<br>" + "Telefone: " 
            + dados.telefoneDoador +"<br>" + "Situação: " + dados.situacaoDoador + 
            "<br>" + "id Funcionário: " +dados.codFuncionario +  "<br> <br>"
        })
        .catch((err) => console.error("Falha ao tentar encontrar Doador!", err))
    document.getElementById('meu-formulario').reset()
});

    

//listar-------------------------------------------------------------------------------------
listar.addEventListener('click', () => {
    fetch('http://localhost:8080/doador')
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML = "";
            dados.forEach(dados => {
                res.innerHTML += "Código: " + dados.codDoador + "<br>" + "Nome: " + dados.nomeDoador +
              "<br> " + "CNPJ: " + dados.cnpjDoador + "<br>" + "CPF: " + dados.cpfDoador +
                 "<br>" + "Endereço: " + dados.enderecoDoador + "<br>" + "Email: " + dados.emailDoador + "<br>" + 
                 "Telefone: " +dados.telefoneDoador +"<br>" + "Situação: " + dados.situacaoDoador +  "<br> <br>";
            });
        })
        .catch((err) => console.error("Falha ao listar todos os Doadores", err));

    document.getElementById('meu-formulario3').reset()
});



//atualizar----------------------------------------------------------------------------------


atualizar.addEventListener('click', () => {
    const codDoador = Number(document.getElementById('codDoador').value);
    const nomeDoador = document.getElementById('nomeDoador').value;
    const cnpjDoador = document.getElementById('cnpjDoador').value;
    const cpfDoador = document.getElementById('cpfDoador').value;
    const enderecoDoador = document.getElementById('enderecoDoador').value;
    const emailDoador = document.getElementById('emailDoador').value;
    const telefoneDoador = document.getElementById('telefoneDoador').value;
    const situacaoDoador = document.getElementById('situacaoDoador').value;
    const codFuncionario = document.getElementById('codFuncionario').value;

    const dados = {
        nomeDoador: nomeDoador, 
        cnpjDoador: cnpjDoador, 
        cpfDoador: cpfDoador, 
        enderecoDoador: enderecoDoador, 
        emailDoador: emailDoador,
        telefoneDoador: telefoneDoador,
        situacaoDoador: situacaoDoador,
        codFuncionario: codFuncionario
    }

    fetch(`http://localhost:8080/doador/${codDoador}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dados)
    })
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML = "Doador atualizado com sucesso!";
        })
        .catch((err) => console.error("Falha ao atualizar o Doador!", err))
});


//deletar-------------------------------------------------------------------

deletar.addEventListener('click', ()=>{
    let codDoador = Number(document.getElementById('codDoador').value)

    fetch(`http://localhost:8080/doador/${codDoador}`,{
        method: "DELETE",
        headers: {"Content-Type":"application/json"}
    })
    .then(resposta => resposta.text())
    .then(dados => {
        res.innerHTML = "Doador apagado com sucesso!"
    })
    .catch((err) => console.error("Erro ao apagar o Doador!", err))
});



