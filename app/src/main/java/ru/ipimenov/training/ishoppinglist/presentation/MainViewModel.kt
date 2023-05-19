package ru.ipimenov.training.ishoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.ipimenov.training.ishoppinglist.data.ShopListRepositoryImpl
import ru.ipimenov.training.ishoppinglist.domain.DeleteShopItemUseCase
import ru.ipimenov.training.ishoppinglist.domain.EditShopItemUseCase
import ru.ipimenov.training.ishoppinglist.domain.GetShopListUseCase
import ru.ipimenov.training.ishoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}