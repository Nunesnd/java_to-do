package br.com.todo_list.dasafiotodolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.todo_list.dasafiotodolist.entidades.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DasafioTodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testeCriadoSucesso() {
		var todo = new Todo("teste1", "descrevendo teste", true, 1);

		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$[0].nome").isEqualTo(todo.getNome())
			.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
			.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
			.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	void testeCriadoFalha() {
	}

}
