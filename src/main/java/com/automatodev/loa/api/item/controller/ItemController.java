package com.automatodev.loa.api.item.controller;

import java.util.List;

import javax.validation.Valid;

import com.automatodev.loa.api.item.service.ItemService;
import com.automatodev.loa.domain.model.entityModel.ItemEntity;
import com.automatodev.loa.domain.model.representationModel.AnnouncementOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//Classe controladora que detem os endpoints referente ao crudo e ações do dos Anuncios publicados

@RestController //Anotação que indica que esta classe é um controlador rest
@RequestMapping("announcement") //Atende tudo que vier com origem deste endpoint
public class ItemController {

	 //Injetando a dependencia de ItemService que possui os metodos de ações jpa para os anuncios
	@Autowired 
	private ItemService iService;
	
	//Metodo http GET que listara todos os anuncios (nao é necessario colocar o endpoint,
	// pois ele atende direto ao endpoint de RequestMapping no escopo da classe)  - para fins administrativos
	@GetMapping("admin/all")
	public List<AnnouncementOutput> getAllAnnounce() {
		return iService.getAll();
	}

	//Metodo http GET que recupera um dado atraves do id no endpoint "announcement" passando atributos no queryParams na urlDinamica
	@GetMapping()
	public List<AnnouncementOutput> getFilterUserDefult(
		@RequestParam String uf,
		@RequestParam String city){
		return iService.getFilterUserDefult(uf,city);
	} 

	//Metodo http GET que recupera um dado atraves do id no endpoint "announcement" declarado em RequestMapping no escopo da classe
	@GetMapping("{id}") 
	public ResponseEntity<AnnouncementOutput> getSingle(@PathVariable long id){
		return ResponseEntity.ok(iService.getById(id));
	}

	//Metodo http POST que realiza a persistencia (gravação) de dados na tabela / tabelas, atendendo ao endpoint "announcement" declarado em RequestMapping no escopo da classe
	@PostMapping 
	public ResponseEntity<AnnouncementOutput> createAnnouncement(@Valid @RequestBody ItemEntity announcementEntity) {
		return ResponseEntity.ok(iService.postItem((announcementEntity)));
	}

	//Metodo http DELETE que realiza a deleção de um anuncio tendo como prarametro o id atendendo ao endpoint "announcement" declarado em RequestMapping no escopo da classe
	@DeleteMapping("{id}") 
	public ResponseEntity<ItemEntity> deletAnnouncement(@PathVariable long id){
		return ResponseEntity.ok(iService.deleteById(id));
	}

	//Metodo http PUT que atualiza um anuncio tendo como prarametro o id atendendo ao endpoint "announcement" declarado em RequestMapping no escopo da classe
	@PutMapping("{id}")
	public ResponseEntity<AnnouncementOutput> updateItem(
		@RequestBody ItemEntity item, 
		@PathVariable("id") long id){
		return ResponseEntity.accepted().body(iService.updaEntity(item, id));
	}

	//Metodo http GET que listara todos os anuncios ativos no endpoint "filter" com os atributos passados na url.
	@GetMapping("filter")
	public ResponseEntity<List<AnnouncementOutput>> getFilterItem(
		@RequestParam(required = false) String title,
		@RequestParam(required = false) String uf,
		@RequestParam(required = false) String city,
		@RequestParam(required = false) String category,
		@RequestParam(required = false) String situation){
		ItemEntity item = new ItemEntity();
		item.setCity(city);
		item.setUf(uf);
		item.setStatusItem("ativo");
		item.setSituation(situation);
		item.setTitle(title);
		item.setCategory(category);
		return ResponseEntity.ok(iService.filterItem(item));
	} 

	//Metodo http GET que listara todos os anuncios ativos com uf e cidade do usuario (nao é necessario colocar o endpoint, pois ele atende direto ao endpoint de RequestMapping no escopo da classe)
/* 	@GetMapping()
	public List<AnnouncementOutput> getAllFilter(
		@RequestParam(required = false) String uf,
		@RequestParam(required = false) String city){
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setUf(uf);
		itemEntity.setStatusItem("ativo");
		itemEntity.setCity(city);

		return this.iService.getAllFilter(itemEntity);
	
	}
	 */
}
