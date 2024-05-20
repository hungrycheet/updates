import { PayAudit } from "../../models/pay-audit.model";
import * as PayAuditActions from './../actions/pay-audit.action';

export interface State {
    payAuditData: any; //TODO set data type here.
    payAuditDataWithFilters:any;
    isLoading: boolean;
    searched: boolean;
    isLoadingWithFilters:any;
    searchedWithFilters:any;
  }
  
  export const initialState: State = {
    payAuditData: null,
    isLoading: false,
    searched: false,
    payAuditDataWithFilters: null,
    isLoadingWithFilters: false,
    searchedWithFilters: false
  };

  export function PayAuditReducer(state = initialState, action: PayAuditActions.Actions) {
    if (action.type === PayAuditActions.TypesActions.GET_PAY_AUDIT_DATA) {
      return JSON.parse(
        JSON.stringify({
          ...state,
          isLoading: true,
          searched: true
        })
      );
    }

    if (action.type === PayAuditActions.TypesActions.GET_PAY_AUDIT_DATA_FILTERS) {
      return JSON.parse(
        JSON.stringify({
          ...state,
          isLoadingWithFilters: true,
          searchedWithFilters: true
        })
      );
    }
  
    if (action.type === PayAuditActions.TypesActions.LOAD_PAY_AUDIT_DATA) {
      return JSON.parse(
        JSON.stringify({
          ...state,
          payAuditData: action.payload,
          isLoading: false,
          searched: true
        })
      );
    }
    if (action.type === PayAuditActions.TypesActions.LOAD_PAY_AUDIT_DATA_FILTERS) {
      return JSON.parse(
        JSON.stringify({
          ...state,
          payAuditDataWithFilters: action.payload,
          isLoadingWithFilters: false,
          searchedWithFilters: true
        })
      );
    }

    if (action.type === PayAuditActions.TypesActions.RESET_PAY_AUDIT_DATA) {
      return initialState;
    }
    return state;
  }