package com.ey.users.utilities;

public interface Messages {

    String NO_USERS = "No existen usuarios para listar";
    String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    String EMPTY = "";
    String EMAIL_NOT_FOUND = "Correo no encontrado";
    String SUCCESSFUL = "Exito";
    String USER_CREATED_SUCCESSFULLY = "Usuario creado exitosamente";
    String USER_FOUND_SUCCESSFULLY = "Usuario encontrado";
    String EMAIL_OR_PASSWORD_WRONG = "Correo o contraseña erronea. Favor revisar";
    String EMAIL_ALREADY_IN_USE = "El correo ya registrado";
    String TOKEN_GENERATED_SUCCESSFULLY = "El token fue generado exitosamente";
    String UNEXPECTED_ERROR = "Hubo un error en la peticion. Favor revisar los parametros, la url, o que el token sea el correcto. Para un nuevo token, usar el path /api/token";


}
