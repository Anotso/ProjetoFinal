
// FUNÇAO CHAMA 


// Obtém o campo de entrada

var input = document.getElementById("senha");
var text = document.getElementById("text12");


// Quando o usuário pressiona qualquer tecla no teclado, execute a função

document.addEventListener('keyup', function( event ) {

  /// Se "caps lock" for pressionado, exibir o texto de aviso
  if (event.getModifierState("CapsLock")) {
    text.style.display = "block";
  } else {
    text.style.display = "none"
  }
});



//funçao mostrar senha
function mostrar() {
  var x = document.getElementById("senha");
  if (x.type === "password") {
      x.type = "text";
  } else {
      x.type = "password";
  }
}
