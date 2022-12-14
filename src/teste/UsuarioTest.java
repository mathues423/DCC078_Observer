package teste;

import main.Distribuidora;
import main.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void deveNotificarUmInscrito() {
        Distribuidora filme = new Distribuidora("Depois de mais de 30 anos de serviço como um dos principais aviadores da Marinha, Pete \"Maverick\" Mitchell está de volta, rompendo os limites como um piloto de testes corajoso. No mundo contemporâneo das guerras tecnológicas, Maverick enfrenta drones e prova que o fator humano ainda é essencial.",
                "Ação", "Top Gun: Maverick");
        Usuario usuario = new Usuario("Usuario 1");
        usuario.inscrever(filme);
        filme.lancarFilme();
        assertEquals("Sr.(a) temos uma novidade confira abaixo {nome: 'Top Gun: Maverick', genero: 'Ação',"
                + " descricao: 'Depois de mais de 30 anos de serviço como um dos principais aviadores da Marinha, Pete \"Maverick\" Mitchell está de volta, rompendo os limites como um piloto de testes corajoso. No mundo contemporâneo das guerras tecnológicas, Maverick enfrenta drones e prova que o fator humano ainda é essencial.'}",
                usuario.getNotificacao());
    }

    @Test
    void deveNotificarInscritos() {
        Distribuidora filme = new Distribuidora("Depois de mais de 30 anos de serviço como um dos principais aviadores da Marinha, Pete \"Maverick\" Mitchell está de volta, rompendo os limites como um piloto de testes corajoso. No mundo contemporâneo das guerras tecnológicas, Maverick enfrenta drones e prova que o fator humano ainda é essencial.",
                "Ação", "Top Gun: Maverick");
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");
        usuario1.inscrever(filme);
        usuario2.inscrever(filme);
        filme.lancarFilme();
        assertEquals("Sr.(a) temos uma novidade confira abaixo {nome: 'Top Gun: Maverick', genero: 'Ação',"
                        + " descricao: 'Depois de mais de 30 anos de serviço como um dos principais aviadores da Marinha, Pete \"Maverick\" Mitchell está de volta, rompendo os limites como um piloto de testes corajoso. No mundo contemporâneo das guerras tecnológicas, Maverick enfrenta drones e prova que o fator humano ainda é essencial.'}",
                usuario1.getNotificacao());
        assertEquals("Sr.(a) temos uma novidade confira abaixo {nome: 'Top Gun: Maverick', genero: 'Ação',"
                        + " descricao: 'Depois de mais de 30 anos de serviço como um dos principais aviadores da Marinha, Pete \"Maverick\" Mitchell está de volta, rompendo os limites como um piloto de testes corajoso. No mundo contemporâneo das guerras tecnológicas, Maverick enfrenta drones e prova que o fator humano ainda é essencial.'}",
                usuario2.getNotificacao());
    }

    @Test
    void naoDeveNotificarInscrito() {
        Distribuidora filme = new Distribuidora("Depois de mais de 30 anos de serviço como um dos principais aviadores da Marinha, Pete \"Maverick\" Mitchell está de volta, rompendo os limites como um piloto de testes corajoso. No mundo contemporâneo das guerras tecnológicas, Maverick enfrenta drones e prova que o fator humano ainda é essencial.",
                "Ação", "Top Gun: Maverick");
        Usuario usuario = new Usuario("Usuario 1");
        filme.lancarFilme();
        assertEquals(null, usuario.getNotificacao());
    }

    @Test
    void deveNotificarInscritoGeneroAcao() {
        Distribuidora filmeAcao = new Distribuidora("Depois de mais de 30 anos de serviço como um dos principais aviadores da Marinha, Pete \"Maverick\" Mitchell está de volta, rompendo os limites como um piloto de testes corajoso. No mundo contemporâneo das guerras tecnológicas, Maverick enfrenta drones e prova que o fator humano ainda é essencial.",
                "Ação", "Top Gun: Maverick");
        Distribuidora filmeFiccao = new Distribuidora("Vincent Freeman sempre sonhou em viajar para o espaço, mas não pode por ser considerado geneticamente inferior. Ele decide desafiar seu destino comprando os genes de Jerome Morrow, e assumindo a sua identidade. Freeman entra para o programa espacial Gattaca e se apaixona por Irene. Uma investigação sobre a morte de um oficial de Gattaca complica os planos de Vincent.",
                "Ficção científica", "Gattaca - A Experiência Genética");
        Usuario usuario1 = new Usuario("Aluno 1");
        Usuario usuario2 = new Usuario("Aluno 2");
        usuario1.inscrever(filmeAcao);
        usuario2.inscrever(filmeFiccao);
        filmeAcao.lancarFilme();
        assertEquals("Sr.(a) temos uma novidade confira abaixo {nome: 'Top Gun: Maverick', genero: 'Ação',"
                        + " descricao: 'Depois de mais de 30 anos de serviço como um dos principais aviadores da Marinha, Pete \"Maverick\" Mitchell está de volta, rompendo os limites como um piloto de testes corajoso. No mundo contemporâneo das guerras tecnológicas, Maverick enfrenta drones e prova que o fator humano ainda é essencial.'}",
                usuario1.getNotificacao());
        assertEquals(null, usuario2.getNotificacao());
    }
}