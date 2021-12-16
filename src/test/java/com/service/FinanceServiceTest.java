package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Finance;
import com.repository.FinanceRepository;
@SpringBootTest
class FinanceServiceTest {
	@Autowired
	FinanceService financeService;
	@MockBean
	FinanceRepository repo;

	@Test
	void testAddBill() {
		Finance f1=new Finance();
		f1.setbId(12);
		f1.setDocFees(150.00);
		f1.setRegFees(150.00);
		f1.setMedAmount(50.00);
		Mockito.when(repo.save(f1)).thenReturn(f1);
		assertThat(financeService.addBill(f1)).isEqualTo(f1);
		
	}

	@Test
	void testAddBills() {
		Finance f1=new Finance();
		f1.setbId(12);
		f1.setDocFees(150.00);
		f1.setRegFees(150.00);
		f1.setMedAmount(50.00);
		Finance f2=new Finance();
		f2.setbId(13);
		f2.setDocFees(150.00);
		f2.setRegFees(150.00);
		f2.setMedAmount(60.00);
		List<Finance> fList=new ArrayList<>();
		fList.add(f1);
		fList.add(f2);
		Mockito.when(repo.findAll()).thenReturn(fList);
		assertThat(financeService.addBills(fList)).isEqualTo(fList);
		
	}

	@Test
	void testGetBills() {
		Finance f1=new Finance();
		f1.setbId(12);
		f1.setDocFees(150.00);
		f1.setRegFees(150.00);
		f1.setMedAmount(50.00);
		Finance f2=new Finance();
		f2.setbId(13);
		f2.setDocFees(150.00);
		f2.setRegFees(150.00);
		f2.setMedAmount(60.00);
		List<Finance> fList=new ArrayList<>();
		fList.add(f1);
		fList.add(f2);
		Mockito.when(repo.findAll()).thenReturn(fList);
		assertThat(financeService.getBills()).isEqualTo(fList);
	}

	@Test
	void testGetBillById() throws Throwable {
		Finance f1=new Finance();
		f1.setbId(12);
		f1.setDocFees(150.00);
		f1.setRegFees(150.00);
		f1.setMedAmount(50.00);
		Optional<Finance> o2=Optional.of(f1);
		Mockito.when(repo.findById(12)).thenReturn(o2);
		assertThat(financeService.getBillById(12)).isEqualTo(f1);
			}

//	@Test
//	void testDeleteBillById() {
//		Finance f1=new Finance();
//		f1.setbId(12);
//		f1.setDocFees(150.00);
//		f1.setRegFees(150.00);
//		f1.setMedAmount(50.00);
//		Optional<Finance> o2=Optional.of(f1);
//		Mockito.when(repo.findById(1)).thenReturn(o2);
//		Mockito.when(repo.existsById(f1.getbId())).thenReturn(false);
//		assertFalse(repo.existsById(f1.getbId()));
//	}

	@Test
	void testDeleteBill() {
		Finance f1=new Finance();
		f1.setbId(12);
		f1.setDocFees(150.00);
		f1.setRegFees(150.00);
		f1.setMedAmount(50.00);
		Optional<Finance> o2=Optional.of(f1);
		Mockito.when(repo.findById(1)).thenReturn(o2);
		Mockito.when(repo.existsById(f1.getbId())).thenReturn(false);
		assertFalse(repo.existsById(f1.getbId()));
	}

	@Test
	void testUpdateBill() throws Throwable {
		Finance f1=new Finance();
		f1.setbId(12);
		f1.setDocFees(150.00);
		f1.setRegFees(150.00);
		f1.setMedAmount(50.00);
		Optional<Finance> o2=Optional.of(f1);
		Mockito.when(repo.findById(12)).thenReturn(o2);
		Mockito.when(repo.save(f1)).thenReturn(f1);
		f1.setDocFees(160.00);
		f1.setRegFees(250.00);
		f1.setMedAmount(100.00);
		assertThat(financeService.updateBill(f1)).isEqualTo(f1);
	}

}