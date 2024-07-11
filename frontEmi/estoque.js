function buscarEstoque() {
    const nomeProduto = document.getElementById("nomeProduto").value;
    
    const url = `http://localhost:8080/estoque/${nomeProduto}`;
    fetch(url, {
      method: "GET",
    })
    .then(response => response.text())
    .then(data => {
      const resultadoDiv = document.getElementById("resultado");
      resultadoDiv.innerHTML = data.estoque ? data.estoque : "Produtos em estoque:" +data;
    })
    .catch(error => {
      console.error("Erro na busca:", error);
      const resultadoDiv = document.getElementById("resultado");
      resultadoDiv.innerHTML = "Erro ao buscar estoque";
    });
  }
  
  function buscarEstoque2() {
   
    const url = `http://localhost:8080/estoque`;  
  
    fetch(url, {
      method: "GET",
    })
    .then(response => response.text())
    .then(data => {
      const resultadoDiv = document.getElementById("resultado");
      resultadoDiv.innerHTML += data.estoque ? data.estoque : "Produtos em estoque:" +data;
    })
    .catch(error => {
      console.error("Erro na busca:", error);
      const resultadoDiv = document.getElementById("resultado");
      resultadoDiv.innerHTML = "Erro ao buscar estoque";
    });
  }