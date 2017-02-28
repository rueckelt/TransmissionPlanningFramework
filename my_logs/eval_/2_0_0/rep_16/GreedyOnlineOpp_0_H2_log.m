
% 2016-12-02 16:24:24

% my_logs/eval_/2_0_0/rep_16/GreedyOnlineOpp_0_H2_log.m
scheduling_duration_us = 1804;

% schedule
schedule_f_t_n(:,:,1) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,2) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 13; 13; 13; 13; 13; 13; 13; 13; 13; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 0; 0; 41; 9; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];

% cost function results
vioSt = [0, 0, 0, 0];
vioDl = [0, 0, 0, 0];
vioNon = [5936, 5940, 144, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [148, 0, 0, 612];
vioLcy = [0, 0, 729, 0];
vioJit = [0, 0, 0, 0];
cost_vio = 73512;
cost_switches = 0;
cost_ch = 57615;
costTotal = 131127;

% GreedyOnlineOpp_0_H2
% 
% ############### Network 0 ##############
% cap	|[0]41	|41	|41	|41	|41	|41	|41	|41	|41	|41	|[10]41	|41	|41	|41	|41	|41	|41	|41	|41	|41	|[20]41	|41	|41	|41	|41	|
% F2	|[0]	|	|	|	|	|	|	|	|	|13	|[10]13	|13	|13	|13	|13	|13	|13	|13	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|41	|9	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
